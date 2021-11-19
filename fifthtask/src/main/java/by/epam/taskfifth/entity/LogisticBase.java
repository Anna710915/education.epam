package by.epam.taskfifth.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase {
    static final Logger logger = LogManager.getLogger();
    private static final int TERMINALS_SIZE = 3;
    private static LogisticBase instance;
    private int terminalSize;
    private static ReentrantLock locker = new ReentrantLock();
    private static AtomicBoolean creator = new AtomicBoolean(false);
    private final Deque<Terminal> freeTerminals = new ArrayDeque<>();
    private final Deque<Condition> usedQueue = new ArrayDeque<>();
    private LogisticBase(){
        this.terminalSize = TERMINALS_SIZE;
        for(int i = 0;i<terminalSize;i++){
            freeTerminals.add(new Terminal());
        }
    }
    public static LogisticBase getInstance(){
        if(!creator.get()){
            try{
                locker.lock();
                if(instance == null){
                    instance = new LogisticBase();
                }
            }finally {
                locker.unlock();
            }
        }
        return instance;
    }
    public Terminal getAccessToTerminal(Lorry lorry){
        try {
            locker.lock();
            Condition condition = locker.newCondition();
            if (freeTerminals.isEmpty()) {
                if(lorry.isSpoilingProduct()){
                    usedQueue.addFirst(condition);
                    logger.log(Level.INFO,"Lorry has spoiling products");
                }else{
                    usedQueue.addLast(condition);
                    logger.log(Level.INFO,"Lorry has not spoiling products");
                }
                condition.await();
            }
        } catch (InterruptedException e) {
            logger.log(Level.ERROR,"The current thread is interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }
        Terminal terminal = freeTerminals.removeFirst();
        logger.log(Level.INFO,"Lorry " + lorry.getLorryId() +
                " is serviced by terminal and spoiling products are " + lorry.isSpoilingProduct());
        return  terminal;
    }
    public void releaseTerminal(Terminal terminal){
        Condition condition = null;
        try{
            locker.lock();
            freeTerminals.addLast(terminal);
            logger.log(Level.INFO,"Terminal is released: " + terminal.getTerminalId());
            condition = usedQueue.pollFirst();
        }finally {
            if(condition != null) {
                condition.signal();
            }
            locker.unlock();
        }
    }
}
