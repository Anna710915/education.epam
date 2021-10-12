package edu.epam.tasksecond.usermain;

import edu.epam.tasksecond.converter.CustomParser;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.factory.impl.SphereFactory;
import edu.epam.tasksecond.reader.CustomReader;
import edu.epam.tasksecond.server.impl.CustomActionSphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ... arg)  {
        try{
            CustomReader reader = new CustomReader();
            CustomParser parser = new CustomParser();
            CustomActionSphere action = new CustomActionSphere();
            SphereFactory creator = new SphereFactory();
            CustomSphere sphere;
            List<String> lines = reader.readFile("datafile/data.txt");
            int counter = 0;
            for(String line: lines){
                double[] arrayPoint = parser.parseLinePoint(line);
                sphere = creator.createSphere(arrayPoint);
            }
        }catch(CustomException ex){
            logger.log(Level.ERROR,ex.getMessage() + ex);
        }catch(Exception e){
            logger.log(Level.ERROR,e.getMessage()+e);
        }
    }
}