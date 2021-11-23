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
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomReader {
    static final Logger logger = LogManager.getLogger();
    public Optional<List<String>> readFiles(String filename) throws CustomException{
        String path = findFilePath(filename);
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> lines = reader.lines()
                    .collect(Collectors.toList());
            Optional<List<String>> optional = lines.size() != 0 ? Optional.of(lines) : Optional.empty();
            logger.log(Level.DEBUG,optional.toString());
            return optional;
        } catch (IOException e) {
            throw new CustomException("File is not found " + filename,e);
        }
    }
    private String findFilePath(String filename) throws CustomException {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(filename);
        if(resource == null){
            throw new CustomException("File is not found!" + filename);
        }
        String path = resource.getPath();
        return path;
    }
}
