package by.epam.taskthird.main;

import by.epam.taskthird.builder.AbstractSweetsBuilder;
import by.epam.taskthird.exception.CustomException;
import by.epam.taskthird.factory.BuilderFactory;
import by.epam.taskthird.validator.ValidatorXml;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class User {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String ... args) {
        String type = "stax";
        try {
            ValidatorXml.validateXml("data/sweets.xml");
            AbstractSweetsBuilder builder = BuilderFactory.createSweetsBuilder(type);
            ClassLoader loader = User.class.getClassLoader();
            URL resource = loader.getResource("data/sweets.xml");
            String path = new File(resource.getFile()).getPath();
            builder.buildSweets(path);
            logger.info(builder.getSweets());

        } catch (CustomException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
