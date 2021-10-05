package edu.epam.taskfirst.reader;

import edu.epam.taskfirst.exception.CustomException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.epam.taskfirst.validator.CheckerNumber;

public class CustomReader {


    public String readFile (String filename) throws CustomException {
        String line = null;
        boolean boolLine = false;
        try(Scanner scanner = new Scanner(new java.io.FileReader(filename))) {
            CheckerNumber checker = new CheckerNumber();
            while(scanner.hasNextLine()) {
                line=scanner.nextLine();
                if(checker.checkLine(line)) {
                    boolLine=true;
                    break;
                }
            }
            if (!boolLine){
                throw new CustomException("File doesn't have a correct line ");
            }
        } catch (FileNotFoundException e) {
            throw new CustomException(("File is not read"));
        }
        return line;
    }

}
