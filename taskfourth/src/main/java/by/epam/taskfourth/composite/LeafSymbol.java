package by.epam.taskfourth.composite;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeafSymbol implements Component{
    private static final Logger logger = LogManager.getLogger();
    private TypeComponent type;
    private String symbol;
    public LeafSymbol(String symbol){
        this.symbol = symbol;
    }
    public LeafSymbol(String symbol, TypeComponent type){ //TODO
        this.symbol = symbol;
        this.type = type;
    }
    @Override
    public void operation() {
    }

    @Override
    public boolean add(Component component) {
        logger.log(Level.WARN,"Component can't add to the leaf element!");
        return false;
    }

    @Override
    public boolean remove(Component component) {
        logger.log(Level.WARN,"Component can't remove from the leaf element!");
        return false;
    }
    @Override
    public String toString(){
        return symbol;
    }
}
