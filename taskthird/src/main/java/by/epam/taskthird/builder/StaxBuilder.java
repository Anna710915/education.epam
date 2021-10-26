package by.epam.taskthird.builder;

import by.epam.taskthird.entity.Sweets;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class StaxBuilder extends SweetsBuilder{
    private XMLInputFactory inputFactory;
    public StaxBuilder(){

    }
    public StaxBuilder(Set<Sweets> sweets){
        super(sweets);
    }
    @Override
    public void buildSweets(String filename) {

    }

}
