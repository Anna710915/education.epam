package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.LeafSymbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler extends AbstractHandler{
    static final String PATTERN_SYMBOL = "\\w";
    @Override
    public void handlerRequest(Component word, String wordText) {
        Pattern pattern = Pattern.compile(PATTERN_SYMBOL);
        Matcher matcher = pattern.matcher(wordText);
        while (matcher.find()){
            for(int i = 0;i< matcher.groupCount()+1;i++){
                LeafSymbol symbol = new LeafSymbol(matcher.group(i));
                word.add(symbol);
            }
        }
    }
}
