package by.epam.taskfifth.reader;

import by.epam.taskfifth.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReader {
    static final Logger logger = LogManager.getLogger();
    public List<String> readFiles(String filename){
        String path = findFilePath(filename);
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> lines = reader.lines()
                    .collect(Collectors.toList());
            if(lines == null){
                throw new CustomException("File is empty");
            }
            logger.log(Level.DEBUG,lines.toString());
            return lines;
        } catch (IOException | CustomException e) {
            logger.log(Level.FATAL,"File is not read or it's empty" + filename);
            throw new RuntimeException("File error ", e);
        }
    }
    private String findFilePath(String filename) {
        try {
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(filename);
            if (resource == null) {
                throw new CustomException("File is not found! " + filename);
            }
            String path = resource.getPath();
            return path;
        }catch (CustomException e){
            logger.log(Level.FATAL,"File is not found" + filename);
            throw new RuntimeException("File error ", e);
        }
    }
}
