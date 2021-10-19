package edu.epam.tasksecond.reader.impl;

import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.reader.CustomReader;
import edu.epam.tasksecond.validator.CustomValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class {@code CustomReader} reads strings from file.
 */
public class CustomReaderImpl implements CustomReader {
    @Override
    public List<String> readFile (String filename) throws CustomException{
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(filename);
        if(resource == null){
            throw new CustomException("Resource is null " + filename);
        }
        String filePath = new File(resource.getFile()).getPath();
        Path path = Paths.get(filePath);
        try(Stream<String> stream = Files.newBufferedReader(path).lines()){

            List<String> lines = stream.filter(s-> CustomValidator.checkLine(s))
                    .collect(Collectors.toList());
            if(lines.isEmpty()){
                throw new CustomException("List is empty " + filename);
            }
            return lines;
        } catch (IOException ex ){
            throw new CustomException("File is not read!",ex);
        }
    }
}
