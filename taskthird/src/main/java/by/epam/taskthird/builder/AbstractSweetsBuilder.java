package by.epam.taskthird.builder;

import by.epam.taskthird.entity.AbstractSweets;
import by.epam.taskthird.exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSweetsBuilder {
    protected Set<AbstractSweets> sweets;
    public AbstractSweetsBuilder(){
        sweets = new HashSet<AbstractSweets>();
    }

    public AbstractSweetsBuilder(Set<AbstractSweets> sweets){
        this.sweets = sweets;
    }
    public Set<AbstractSweets> getSweets() {
        return sweets;
    }

    public abstract void buildSweets(String filename) throws CustomException;
}
