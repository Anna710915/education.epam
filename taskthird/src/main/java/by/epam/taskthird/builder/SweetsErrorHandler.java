package by.epam.taskthird.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;



public class SweetsErrorHandler implements ErrorHandler {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.log(Level.WARN,getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.log(Level.ERROR,getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.log(Level.FATAL,getLineColumnNumber(exception) + "-" + exception.getMessage());
    }
    private String getLineColumnNumber(SAXParseException exception) {
        //determine line and position of error
        return  exception.getLineNumber() + " : " + exception.getColumnNumber();
    }
}
