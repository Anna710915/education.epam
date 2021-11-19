package by.epam.taskfifth.main;



import by.epam.taskfifth.entity.Lorry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ...args) {
        List<Lorry> list = new ArrayList<>();
        list.add(new Lorry(1,false));
        list.add(new Lorry(2,true));
        list.add(new Lorry(3,false));
        list.add(new Lorry(4,false));
        list.add(new Lorry(5,false));
        list.add(new Lorry(6,true));
        list.add(new Lorry(7,false));
        list.add(new Lorry(8,true));
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<String>> listFuture= new ArrayList<>();
       for(Lorry lorry:list){
           listFuture.add(executor.submit(lorry));
       }
       for(Future<String> future:listFuture){
           try {
               logger.log(Level.INFO,future.get());
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }
       executor.shutdown();
    }
}
