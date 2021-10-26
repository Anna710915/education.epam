package by.epam.taskthird.validator;

import by.epam.taskthird.builder.SweetsErrorHandler;
import by.epam.taskthird.exception.CustomException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ValidatorXml {
    private static final String SCHEMA_NAME = "data/sweets.xsd";
    public static void validateXml(String filename) throws CustomException{
        ClassLoader loader = ValidatorXml.class.getClassLoader();
        URL resourceSchema = loader.getResource(SCHEMA_NAME);
        String schemaPath = new File(resourceSchema.getFile()).getPath();
        URL resourceFile = loader.getResource(filename);
        String filePath = new File(resourceFile.getFile()).getPath();
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaPath);
        try{
            //schema creation
            Schema schema = factory.newSchema(schemaLocation);
            //creating a schema-based validator
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath);
            //document check
            validator.setErrorHandler(new SweetsErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new CustomException(filename + "is not correct or valid!", e);
        }
    }
}
