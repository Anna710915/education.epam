package by.epam.taskfifth.entity;

import by.epam.taskfifth.exception.CustomException;
import by.epam.taskfifth.parser.CustomParser;
import by.epam.taskfifth.reader.CustomReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class LogisticBase {
    static final Logger logger = LogManager.getLogger();
    private static LogisticBase instance;
    private static ReentrantLock lockerSingleton = new ReentrantLock();
    private static AtomicBoolean creator = new AtomicBoolean(false);
    private ReentrantLock locker = new ReentrantLock();
    private Deque<Terminal> freeTerminals = new ArrayDeque<>();
    private Deque<Condition> usedQueue = new ArrayDeque<>();
    private LogisticBase(){
        init();
    }
    private void init(){
        String filename = "src\\main\\resources\\terminal.txt";
        CustomReader reader = new CustomReader();
        try {
            Optional<List<String>> optionalTerminals = reader.readFiles(filename);
            if(optionalTerminals.isPresent()){
                List<String> listTerminals = optionalTerminals.get();
                CustomParser parser = new CustomParser();
                for(String line:listTerminals) {
                    Terminal terminal = parser.parseTerminals(line);
                    freeTerminals.add(terminal);
                }
            }else{
                throw new CustomException("The list of terminals is empty" + filename);
            }
        } catch (CustomException e) {
            throw new UnsupportedOperationException(e);
        }
    }
    public static LogisticBase getInstance(){
        if(!creator.get()){
            try{
                lockerSingleton.lock();
                if(instance == null){
                    instance = new LogisticBase();
                    creator.set(true);
                }
            }finally {
                lockerSingleton.unlock();
            }
        }
        return instance;
    }
    public Terminal getAccessToTerminal(Lorry lorry){
        Terminal terminal = null;
        try {
            locker.lock();
            Condition condition = locker.newCondition();
            if (freeTerminals.isEmpty()) {
                if(lorry.isSpoilingProduct()){
                    usedQueue.addFirst(condition);
                    logger.log(Level.INFO,"Lorry has spoiling products");
                }else{
                    usedQueue.addLast(condition);
                    logger.log(Level.INFO,"Lorry does not have spoiling products");
                }
                condition.await();
            }
            terminal = freeTerminals.removeFirst();
        } catch (InterruptedException e) {
            logger.log(Level.ERROR,"The current thread is interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }
        logger.log(Level.INFO,"Lorry " + lorry.getLorryId() +
                " is serviced by terminal and spoiling products are " + lorry.isSpoilingProduct());

        return terminal;
    }
    public void releaseTerminal(Terminal terminal){
        Condition condition = null;
        try{
            locker.lock();
            TimeUnit.SECONDS.sleep(3);
            freeTerminals.addLast(terminal);
            logger.log(Level.INFO,"Terminal is released: " + terminal.getTerminalId());
            condition = usedQueue.pollFirst();
        }catch(InterruptedException e){
            logger.log(Level.ERROR,"The current thread is interrupted", e);
            Thread.currentThread().interrupt();
        }finally {
            if(condition != null) {
                condition.signal();
            }
            locker.unlock();
        }
    }
    public void checkSizeTerminals(){
        freeTerminals.forEach(o->{
            if(o.getSize()>0.7*o.getMaxSize()){
                o.setSize(50);
            }else if(o.getSize()<o.getMaxSize()*0.3){
                o.setSize(50);
            }
        });
    }
}
