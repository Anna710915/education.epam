package by.epam.taskfourth.reader;

import by.epam.taskfourth.exception.CustomException;
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
import java.util.stream.Stream;

/**
 * Class {@code CustomReader} reads information from file.
 */
public class CustomReader {
    private static final Logger logger = LogManager.getLogger();

    /**
     *
     * @param filename is a name of file
     * @return Optional
     * @throws CustomException if file is not read
     */
    public Optional<List<String>> readFile(String filename) throws CustomException {
        String path = findPath(filename);
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Stream<String> stream = reader.lines();
            List<String> textLines = stream.collect(Collectors.toList());
            Optional<List<String>> optionalText =
                    textLines.size()!= 0 ? Optional.of(textLines) : Optional.empty();
            logger.log(Level.DEBUG,optionalText.toString());
            return optionalText;
        } catch (IOException e) {
            throw new CustomException("File is not read!" + filename, e);
        }
    }

    /**
     *
     * @param filename is a name of file
     * @return a file path.
     * @throws CustomException if path is not found
     */
    private String findPath(String filename) throws CustomException{
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(filename);
        if(resource == null){
            throw new CustomException("File is not found!" + filename);
        }
        String path = resource.getPath();
        return path;
    }
}
