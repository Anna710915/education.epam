package by.epam.taskfifth.parser;

import by.epam.taskfifth.entity.Lorry;
import by.epam.taskfifth.entity.Terminal;

public class CustomParser {
    static final String REGEX_DELIMITER = "\\s+";
    static final char EQUALS_DELIMITER = '=';
    static final String PATTERN_SPOILING = "true";
    static final String PATTERN_UPLOAD = "upload";
    public Terminal parseTerminals(String lineTerminal){
        Terminal terminal = null;
        int index;
        lineTerminal = lineTerminal.trim();
        String[] infoTerminal= lineTerminal.split(REGEX_DELIMITER);
        if(infoTerminal.length == 2){
           index = infoTerminal[0].indexOf(EQUALS_DELIMITER);
           long id = Long.parseLong(infoTerminal[0].substring(index+1));
           index = infoTerminal[1].indexOf(EQUALS_DELIMITER);
           int size = Integer.parseInt(infoTerminal[1].substring(index+1));
           terminal = new Terminal(id,size);
        }else{
            throw new IllegalArgumentException("The length is " + infoTerminal.length);
        }
        return terminal;
    }
    public Lorry parseLorry(String lineLorry){
        Lorry lorry = null;
        int index;
        lineLorry = lineLorry.trim();
        String[] infoTerminal= lineLorry.split(REGEX_DELIMITER);
        if(infoTerminal.length == 4){
            index = infoTerminal[0].indexOf(EQUALS_DELIMITER);
            long id = Long.parseLong(infoTerminal[0].substring(index+1));
            index = infoTerminal[1].indexOf(EQUALS_DELIMITER);
            boolean spoiling = infoTerminal[1].substring(index+1)
                    .matches(PATTERN_SPOILING);
            index = infoTerminal[2].indexOf(EQUALS_DELIMITER);
            boolean upload = infoTerminal[2].substring(0,index).matches(PATTERN_UPLOAD);
            int productSize = Integer.parseInt(infoTerminal[2].substring(index+1));
            index = infoTerminal[3].indexOf(EQUALS_DELIMITER);
            int maxSize = Integer.parseInt(infoTerminal[3].substring(index+1));
            lorry = new Lorry(id,spoiling,upload,productSize,maxSize);
        }else{
            throw new IllegalArgumentException("The length is " + infoTerminal.length);
        }
        return lorry;
    }
}
