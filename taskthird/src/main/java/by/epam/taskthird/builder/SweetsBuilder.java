package by.epam.taskthird.builder;

import by.epam.taskthird.entity.Sweets;
import by.epam.taskthird.exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class SweetsBuilder {
    protected Set<Sweets> sweets;
    public SweetsBuilder(){
        sweets = new HashSet<Sweets>();
    }

    public SweetsBuilder(Set<Sweets> sweets){
        this.sweets = sweets;
    }
    public Set<Sweets> getSweets() {
        return sweets;
    }

    public abstract void buildSweets(String filename) throws CustomException;
}
