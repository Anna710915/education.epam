package by.epam.taskfifth.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Terminal {
    static final Logger logger = LogManager.getLogger();
    static final int MAX_SIZE = 100;
    private final Random random = new Random();
    private final long terminalId;
    private int size;
    public Terminal(long terminalId, int size){
        this.terminalId = terminalId;
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTerminalId() {
        return terminalId;
    }
    public void serveLorry(Lorry lorry){
        try{
            TimeUnit.SECONDS.sleep(random.nextInt(1,10));
            size = lorry.isUpload() ? size - lorry.getProducts() : size + lorry.getProducts();
            logger.log(Level.INFO, "The rest is " + size);
            logger.log(Level.INFO,"Terminal " + getTerminalId() + "has served a lorry " + lorry.getLorryId() +
                    " and spoiling products are " + lorry.isSpoilingProduct());
        }catch(InterruptedException e){
            logger.log(Level.ERROR,"Thread was interrupted while sleeping",e);
            Thread.currentThread().interrupt();
        }
    }
}
