package edu.epam.taskfirst.reader;

import edu.epam.taskfirst.exception.CustomException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import edu.epam.taskfirst.validator.CheckerNumber;

public class CustomReader {


    public String readFile (String filename) throws CustomException {
        try{
            Path path = Path.of(filename);
            Stream<String> stream = Files.lines(path);
            return stream.filter(s -> CheckerNumber.checkLine(s))
                    .findFirst()
                    .orElseThrow(()->new CustomException("File is not read"));

        } catch (CustomException | IOException e) {
            throw new CustomException("File is not read",e);
        }
    }
}
