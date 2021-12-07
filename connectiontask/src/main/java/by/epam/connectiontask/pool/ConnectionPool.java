package by.epam.connectiontask.pool;

import by.epam.connectiontask.exception.CustomException;
import by.epam.connectiontask.factory.ConnectionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    static final Logger logger = LogManager.getLogger();
    private static final Properties properties = new Properties();
    private static final int DEFAULT_POOL_SIZE;
    private static AtomicBoolean create = new AtomicBoolean(false);
    private static ReentrantLock lockerCreator = new ReentrantLock();
    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> giveAwayConnections;

    static {
        try {
            String fileName = "data/database.properties";
            ClassLoader loader = ConnectionFactory.class.getClassLoader();
            URL resource = loader.getResource(fileName);
            if(resource != null) {
                fileName = resource.getFile();
            }else{
                logger.log(Level.ERROR,"Resource is null! " + fileName);
                throw new IllegalArgumentException();
            }
            properties.load(new FileReader(fileName));
        }catch (IOException e){
            logger.log(Level.FATAL,"File properties exception: " + e.getMessage());
            throw new RuntimeException();
        }
        DEFAULT_POOL_SIZE = Integer.parseInt((String) properties.get("poolsize"));
    }

    private  ConnectionPool(){
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        giveAwayConnections = new ArrayDeque<>();
        for(int i = 0; i < DEFAULT_POOL_SIZE; i++){
            try{
                ProxyConnection connection = new ProxyConnection(ConnectionFactory.createConnection());
                boolean isCreated = freeConnections.offer(connection);
                logger.log(Level.DEBUG,"Connection is " + isCreated);
            }catch (CustomException e){
                logger.log(Level.ERROR,"Connection was not created " + e.getMessage());
            }
        }
        if(freeConnections.isEmpty()){
            logger.log(Level.FATAL,"There are not connections!");
            throw new RuntimeException();
        }else if (freeConnections.size() < DEFAULT_POOL_SIZE){
            int connectionSize = freeConnections.size();
            while (connectionSize!=DEFAULT_POOL_SIZE){ //Question
                try {
                    ProxyConnection connection = new ProxyConnection(ConnectionFactory.createConnection());
                    freeConnections.offer(connection);
                }catch (CustomException e){
                    logger.log(Level.ERROR,"Connection was not created " + e.getMessage());
                }
                connectionSize++;
            }
        }
    }

    public static ConnectionPool getInstance(){
        if(!create.get()){
            try{
                lockerCreator.lock();
                if(instance == null){
                    instance = new ConnectionPool();
                    create.set(true);
                }
            }finally {
                lockerCreator.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection(){
        ProxyConnection connection = null;
        try{
            connection = freeConnections.take();
            giveAwayConnections.offer(connection);
        }catch (InterruptedException e){
            logger.log(Level.ERROR,"The thread was interrupted!" + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection){
        try {
            if(connection.getClass() != ProxyConnection.class){
                throw new CustomException("Illegal connection!");
            }
            ProxyConnection proxyConnection = (ProxyConnection) connection;
            giveAwayConnections.remove(connection);
            freeConnections.put(proxyConnection);
        }catch (CustomException | InterruptedException e){
            logger.log(Level.ERROR,e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void destroyPool(){
        for(int i = 0; i < DEFAULT_POOL_SIZE; i++){
            try {
                freeConnections.take().reallyClose();
                logger.log(Level.DEBUG,"Connection closed!");
            } catch (InterruptedException e) {
                logger.log(Level.ERROR,"The thread was interrupted!" + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        deregisterDrivers();
    }
    private void deregisterDrivers(){
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
                logger.log(Level.DEBUG, "Deregister driver.");
            } catch (SQLException e) {
                logger.log(Level.ERROR, "The driver was not removed");
            }
        });
    }
}
