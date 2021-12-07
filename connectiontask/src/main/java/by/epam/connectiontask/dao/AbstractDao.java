package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.CustomEntity;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.pool.ProxyConnection;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao <T extends CustomEntity>{
    static final Logger logger = LogManager.getLogger();
    protected ProxyConnection proxyConnection;

    public abstract List<T> findAll() throws DaoException;
    public abstract T findEntityById(long id) throws DaoException;
    public abstract boolean delete(long id) throws DaoException;
    public abstract boolean delete(T entity) throws DaoException;
    public abstract boolean create(T entity) throws DaoException;
    public abstract T update(T entity) throws DaoException;

    public void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR,"Statement was not released. " + e.getMessage());
        }
    }
    void setConnection(Connection connection){
        this.proxyConnection = (ProxyConnection) connection;
    }
}
