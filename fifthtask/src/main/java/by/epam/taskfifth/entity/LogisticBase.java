package by.epam.taskfifth.entity;

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

public class LogisticBase {
    static final Logger logger = LogManager.getLogger();
    private static LogisticBase instance;
    private static ReentrantLock lockerCreator = new ReentrantLock();
    private static AtomicBoolean creator = new AtomicBoolean(false);
    private ReentrantLock locker = new ReentrantLock();
    private Deque<Terminal> freeTerminals = new ArrayDeque<>();
    private Deque<Condition> nonPerishableQueue = new ArrayDeque<>();
    private Deque<Condition> perishableQueue = new ArrayDeque<>();
    private LogisticBase(){
        String filename = "data/terminal.txt";
        CustomReader reader = new CustomReader();
        List<String> listTerminals = reader.readFiles(filename);
        CustomParser parser = new CustomParser();
        for(String line:listTerminals) {
            Terminal terminal = parser.parseTerminals(line);
            freeTerminals.add(terminal);
        }
    }

    public static LogisticBase getInstance(){
        if(!creator.get()){
            try{
                lockerCreator.lock();
                if(instance == null){
                    instance = new LogisticBase();
                    startTimer();
                    creator.set(true);
                }
            } finally {
                lockerCreator.unlock();
            }
        }
        return instance;
    }

    private static void startTimer(){
        Timer timer = new Timer(true);
        timer.schedule(new TimerThread(),0,500);
    }

    public Terminal getAccessToTerminal(Lorry lorry){
        Terminal terminal = null;
        try {
            locker.lock();
            TimeUnit.SECONDS.sleep(2);
            Condition condition = locker.newCondition();
            if (freeTerminals.isEmpty()) {
                if(lorry.isSpoilingProduct()){
                    perishableQueue.addLast(condition);
                    logger.log(Level.INFO,"Lorry has spoiling products");
                }else{
                    nonPerishableQueue.addLast(condition);
                    logger.log(Level.INFO,"Lorry does not have spoiling products");
                }
                condition.await();
            }
            terminal = freeTerminals.removeFirst();
            logger.log(Level.INFO,"Lorry " + lorry.getLorryId() +
                    " is serviced by terminal and spoiling products are " + lorry.isSpoilingProduct());
        } catch (InterruptedException e) {
            logger.log(Level.ERROR,"The current thread is interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }
        return terminal;
    }

    public void releaseTerminal(Terminal terminal){
        Condition condition = null;
        try{
            locker.lock();
            freeTerminals.addLast(terminal);
            TimeUnit.SECONDS.sleep(1);
            logger.log(Level.INFO,"Terminal is released: " + terminal.getTerminalId());
            condition = perishableQueue.isEmpty() ? nonPerishableQueue.pollFirst() : perishableQueue.pollFirst();
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
            if(o.getSize()>0.7*Terminal.MAX_SIZE){
                o.setSize(Terminal.MAX_SIZE/2);
            }else if(o.getSize()<Terminal.MAX_SIZE*0.3){
                o.setSize(Terminal.MAX_SIZE/2);
            }
        });
    }
}
