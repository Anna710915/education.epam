package by.epam.taskthird.builder;

import by.epam.taskthird.entity.Sweets;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class DomBuilder extends SweetsBuilder{
    private DocumentBuilder docbuilder;
    public DomBuilder(){}
    public DomBuilder(Set<Sweets> sweets){
        super(sweets);
    }
    @Override
    public void buildSweets(String filename) {

    }
}
