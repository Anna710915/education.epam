package edu.epam.zerotask0.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReaderFile {
    public static final String REGEX_1 = " +";
    public static final String REGEX_2 = "\\s+";
    static Logger Logger = LogManager.getLogger();
    public String[] readNumbers(String filename) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filename);
        Scanner scan = new Scanner(fileReader);
        String line = scan.nextLine();
        line=line.replaceAll(REGEX_1," ");
        line=line.trim();
        String[] numbers = line.split(REGEX_2);
        Logger.log(Level.INFO,"File is read");
        return numbers;
    }
}