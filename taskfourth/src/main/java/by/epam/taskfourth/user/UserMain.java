package by.epam.taskfourth.user;


import by.epam.taskfourth.chain.AbstractHandler;
import by.epam.taskfourth.chain.TextHandler;
import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.TypeComponent;
import by.epam.taskfourth.convertor.CustomConvertor;
import by.epam.taskfourth.exception.CustomException;
import by.epam.taskfourth.reader.CustomReader;
import by.epam.taskfourth.service.CustomAction;
import by.epam.taskfourth.comparator.ParagraphComparator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ... args){
        String filename = "data/text.txt";
        String string = new String("Aaa");
        string=string.toLowerCase();
        CustomReader reader = new CustomReader();
        CustomConvertor convertor;
        try{
            Optional<List<String>> textLines = reader.readFile(filename);
            if(textLines.isPresent()){
                convertor = new CustomConvertor();
                String text = convertor.makeText(textLines.get());
                AbstractHandler handler = new TextHandler();
                Composite composite = new CompositeImpl(TypeComponent.TEXT);
                handler.handlerRequest(composite,text);
                //logger.info(composite.toString());
                CustomAction action = new CustomAction();
                List<Composite> text1 = action.sortParagraphs(composite,new ParagraphComparator());
                logger.info(text1.toString());
                Map<String,Integer> map = new HashMap<>();
                action.findSentenceByMaxWord(composite,map);
                map.forEach((k,v)->logger.info(k+v));
                logger.info(composite.toString());

            }
        }catch (CustomException e){
            logger.log(Level.ERROR,e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.ERROR,e.getMessage());
        }
    }
}
