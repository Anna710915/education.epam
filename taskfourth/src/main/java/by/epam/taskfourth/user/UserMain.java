package by.epam.taskfourth.user;


import by.epam.taskfourth.chain.AbstractHandler;
import by.epam.taskfourth.chain.TextHandler;
import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.ComponentImpl;
import by.epam.taskfourth.conventor.CustomConvertor;
import by.epam.taskfourth.exception.CustomException;
import by.epam.taskfourth.reader.CustomReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ... args){
        String filename = "data/text.txt";

        CustomReader reader = new CustomReader();
        CustomConvertor convertor;
        try{
            Optional<List<String>> textLines = reader.readFile(filename);
            if(textLines.isPresent()){
                convertor = new CustomConvertor();
                String text = convertor.makeText(textLines.get());
                AbstractHandler handler = new TextHandler();
                Component component = new ComponentImpl();
                handler.handlerRequest(component,text);
                logger.info(component.toString());
            }
        }catch (CustomException e){
            logger.log(Level.ERROR,"error");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.ERROR,"error");
        }
    }
}
