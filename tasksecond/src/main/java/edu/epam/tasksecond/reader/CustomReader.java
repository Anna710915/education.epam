package edu.epam.tasksecond.reader;

import edu.epam.tasksecond.exception.CustomException;

import java.util.List;

public interface CustomReader {
    /**
     *
     * @param filename is a file path.
     * @return a list of strings.
     * @throws CustomException if the file is not read or the path
     * is incorrect.
     */
    List<String> readFile (String filename) throws CustomException;
}
