package by.epam.taskfifth.main;



import by.epam.taskfifth.entity.Lorry;
import by.epam.taskfifth.entity.TimerThread;
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
        String filename = "src\\main\\resources\\lorry.txt";
        CustomReader reader = new CustomReader();
        CustomParser parser = new CustomParser();
        Timer timer = new Timer(true);
        timer.schedule(new TimerThread(),0,100);
        try {
            Optional<List<String>> optional = reader.readFiles(filename);
            List<String> list = optional.isPresent() ? optional.get() : null;
            if(list.isEmpty()){
                throw new IllegalArgumentException();
            }
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
        }catch(InterruptedException | CustomException e){
            logger.log(Level.ERROR,"CustomException or InterruptedException", e);
        }catch (ExecutionException e ){
            logger.log(Level.ERROR,"ExecutionException ", e);
        }
    }
}
