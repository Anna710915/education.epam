package by.epam.taskthird.builder;

import by.epam.taskthird.entity.AbstractSweets;
import by.epam.taskthird.exception.CustomException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SaxBuilder extends AbstractSweetsBuilder {
    private XMLReader reader;
    private SweetsHandler handler;
    public SaxBuilder() throws CustomException{
        handler = new SweetsHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            throw new CustomException("SAX parse doesn't work!", e);
        }
        reader.setContentHandler(handler);
        reader.setErrorHandler(new SweetsErrorHandler());
    }
    public SaxBuilder(Set<AbstractSweets> sweets){
        super(sweets);
    }
    @Override
    public void buildSweets(String filename) throws CustomException{
        try{
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            throw new CustomException("Error of reading" + filename, e);
        }
        sweets = handler.getSweets();
    }
}
