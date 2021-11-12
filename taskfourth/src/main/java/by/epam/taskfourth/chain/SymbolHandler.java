package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.LeafSymbol;
import by.epam.taskfourth.composite.TypeComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class {@code SymbolHandler} splits a word into symbols.
 */
public class SymbolHandler extends AbstractHandler{
    static final String PATTERN_SYMBOL = ".";
    @Override
    public void handlerRequest(Composite word, String wordText) {
        Pattern pattern = Pattern.compile(PATTERN_SYMBOL);
        Matcher matcher = pattern.matcher(wordText);
        while (matcher.find()){
            for(int i = 0;i< matcher.groupCount()+1;i++){
                LeafSymbol symbol = new LeafSymbol(matcher.group(i).charAt(i), TypeComponent.SYMBOL);
                word.add(symbol);
            }
        }
    }
}
