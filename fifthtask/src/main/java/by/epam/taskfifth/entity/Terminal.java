package by.epam.taskfifth.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Terminal {
    static final Logger logger = LogManager.getLogger();
    private static long i = 1;
    private final long terminalId;
    public Terminal(){
        this.terminalId = i;
        i++;
    }

    public long getTerminalId() {
        return terminalId;
    }
    public void serveLorry(Lorry lorry){
        try{
            TimeUnit.SECONDS.sleep((int)Math.random()*10+1);
        }catch(InterruptedException e){
            logger.log(Level.ERROR,"Thread was interrupted while sleeping",e);
            Thread.currentThread().interrupt();
        }
        logger.info("Terminal"+getTerminalId()+"has served a lorry "+lorry.getLorryId()+
                " and spoiling products are " + lorry.isSpoilingProduct());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terminal)) return false;
        Terminal terminal = (Terminal) o;
        return getTerminalId() == terminal.getTerminalId();
    }
}
