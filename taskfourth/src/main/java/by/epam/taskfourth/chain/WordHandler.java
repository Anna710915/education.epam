package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.ComponentImpl;
import by.epam.taskfourth.composite.LeafPunct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends AbstractHandler{
    static final String PATTERN_WORD_PUNCT = "\\p{Punct}|\\w+|\n";
    static final String PATTERN_PUNCT = "\\p{Punct}|\n";
    static final String PATTERN_WORD = "\\w+";
    private AbstractHandler handler = new SymbolHandler();
    @Override
    public void handlerRequest(Component lexeme, String lexemeText) {
        Pattern pattern = Pattern.compile(PATTERN_WORD_PUNCT);
        Matcher matcher = pattern.matcher(lexemeText);
        while (matcher.find()){
            for(int i = 0;i< matcher.groupCount()+1;i++){
                if(matcher.group(i).matches(PATTERN_WORD)){
                    Component word = new ComponentImpl();
                    lexeme.add(word);
                    handler.handlerRequest(word,matcher.group(i));
                }else if(matcher.group(i).matches(PATTERN_PUNCT)){
                    LeafPunct punct = new LeafPunct(matcher.group(i));
                    lexeme.add(punct);
                }
            }
        }
    }
}
