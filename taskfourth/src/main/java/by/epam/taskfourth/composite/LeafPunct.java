package by.epam.taskfourth.composite;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeafPunct implements Component{
    private static final Logger logger = LogManager.getLogger();
    private TypeComponent type;
    private String punct;
    public LeafPunct(String punct){
        this.punct = punct;
    }
    public LeafPunct(String punct, TypeComponent type){//TODO
        this.punct = punct;
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
    public String toString() {
        return punct;
    }
}
