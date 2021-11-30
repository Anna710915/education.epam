package by.epam.taskfifth.main;



import by.epam.taskfifth.entity.Lorry;
import by.epam.taskfifth.exception.CustomException;
import by.epam.taskfifth.parser.CustomParser;
import by.epam.taskfifth.reader.CustomReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ...args) {
        String filename = "data/lorry.txt";
        CustomReader reader = new CustomReader();
        CustomParser parser = new CustomParser();
        try {
            List<String> list = reader.readFiles(filename);
            ExecutorService executor = Executors.newFixedThreadPool(list.size());
            ArrayList<Future<String>> listFuture = new ArrayList<>();
            for (String line : list) {
                Lorry lorry = parser.parseLorry(line);
                listFuture.add(executor.submit(lorry));
            }
            executor.shutdown();
            for (Future<String> future : listFuture) {
                    logger.log(Level.INFO, future.get());
            }
        }catch(InterruptedException e){
            logger.log(Level.ERROR,"CustomException or InterruptedException", e);
        }catch (ExecutionException e ){
            logger.log(Level.ERROR,"ExecutionException ", e);
        }
    }
}
