package edu.epam.taskfirst.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import edu.epam.taskfirst.validator.CheckerNumber;

public class Reader {
    static Logger Logger = LogManager.getLogger();

    public String readFile (String filename) {
        String line = null;
        try(Scanner scanner = new Scanner(new FileReader(filename))) {
            CheckerNumber checker = new CheckerNumber();
            while((line=scanner.nextLine())!=null) {
                if(checker.checkLine(line)) {
                    break;
                }
            }
            if (line==null){
                throw new Exception();
            }
        } catch (FileNotFoundException e) {
            Logger.log(Level.ERROR,e);
            System.exit(-1);
        } catch (Exception e) {
            Logger.log(Level.ERROR,e);
            System.exit(-1);
        }
        return line;
    }

}
