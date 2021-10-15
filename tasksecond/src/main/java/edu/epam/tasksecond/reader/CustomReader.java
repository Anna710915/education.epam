package edu.epam.tasksecond.reader;

import edu.epam.tasksecond.exception.CustomException;

import java.util.List;

public interface CustomReader {
    List<String> readFile (String filename) throws CustomException;
}
