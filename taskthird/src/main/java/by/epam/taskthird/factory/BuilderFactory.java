package by.epam.taskthird.factory;

import by.epam.taskthird.builder.DomBuilder;
import by.epam.taskthird.builder.SaxBuilder;
import by.epam.taskthird.builder.StaxBuilder;
import by.epam.taskthird.builder.AbstractSweetsBuilder;
import by.epam.taskthird.exception.CustomException;

public class BuilderFactory {
    private enum TypeParser{
        SAX, STAX, DOM
    }
    private BuilderFactory(){

    }
    public static AbstractSweetsBuilder createSweetsBuilder(String typeParser) throws CustomException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type){
            case DOM -> {
                return new DomBuilder();
            }
            case SAX -> {
                return new SaxBuilder();
            }
            case STAX -> {
                return new StaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
