package edu.epam.tasksecond.usermain;

import edu.epam.tasksecond.comparator.SphereFirstPointX;
import edu.epam.tasksecond.converter.impl.CustomParserImpl;
import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.factory.impl.SphereFactoryImpl;
import edu.epam.tasksecond.observer.impl.SphereObserver;
import edu.epam.tasksecond.reader.impl.CustomReaderImpl;
import edu.epam.tasksecond.repository.ShapeRepository;
import edu.epam.tasksecond.server.impl.CustomActionSphere;
import edu.epam.tasksecond.warehouse.Warehouse;
import edu.epam.tasksecond.warehouse.impl.WarehouseEditorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class UserMain {
    static final Logger logger = LogManager.getLogger();
    public static void main(String ... arg)  {
        try{
            Warehouse warehouse = Warehouse.getInstance();
            ShapeRepository repository = ShapeRepository.getInstance();
            CustomReaderImpl reader = new CustomReaderImpl();
            CustomParserImpl parser = new CustomParserImpl();
            SphereFactoryImpl creator = new SphereFactoryImpl();
            WarehouseEditorImpl house = new WarehouseEditorImpl();
            List<String> lines = reader.readFile("datafile/data.txt");
            for(String line: lines){
                double[] arrayPoint = parser.parseLinePoint(line);
                CustomSphere sphere = creator.createSphere(arrayPoint);
                repository.add(sphere);
                house.addToWarehouse(sphere);
            }
            SphereObserver observer = new SphereObserver();
            CustomSphere sphere = repository.get(0);
            CustomSphere a = new CustomSphere(new CustomPoint(2,2,2),2);
            CustomActionSphere action = new CustomActionSphere();
            logger.log(Level.INFO,action.planeOx(a));
            sphere.attach(observer);
            logger.log(Level.INFO, repository.get(0).toString());
            logger.log(Level.INFO, warehouse.get(1L).getSquare());
            logger.log(Level.INFO, warehouse.get(1L).getVolume());
            sphere.setRadius(2.5);
            logger.log(Level.INFO, repository.get(0).toString());
            logger.log(Level.INFO, warehouse.get(1L).getSquare());
            logger.log(Level.INFO, warehouse.get(1L).getVolume());
            List<CustomSphere> select = repository.sort(new SphereFirstPointX());
            Iterator<CustomSphere> iterator = select.iterator();
            while(iterator.hasNext()){
                logger.log(Level.INFO, iterator.next().toString());
            }
        }catch(CustomException ex){
            logger.log(Level.ERROR, ex);
        }catch(Exception e){
            logger.log(Level.ERROR, e);
        }
    }
}