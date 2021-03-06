package by.epam.taskfourth.composite;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LeafSymbol implements Composite {
    private static final Logger logger = LogManager.getLogger();
    private TypeComponent type;
    private char symbol;

    public LeafSymbol(char symbol){

        this.symbol = symbol;
    }

    public LeafSymbol(char symbol, TypeComponent type){
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public boolean add(Composite composite) {
        logger.log(Level.ERROR,"Component can't add to the leaf element!");
        throw new UnsupportedOperationException("Leaf element is " + getTypeComponent());
    }

    @Override
    public boolean remove(Composite composite) {
        logger.log(Level.ERROR,"Component can't remove from the leaf element!");
        throw new UnsupportedOperationException("Leaf element is " + getTypeComponent());
    }

    @Override
    public TypeComponent getTypeComponent() {
        return type;
    }

    @Override
    public List<Composite> getComposites() {
        throw new UnsupportedOperationException("Leaf element doesn't contain any elements");
    }

    @Override
    public String toString(){
        return Character.toString(symbol);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
