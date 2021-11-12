package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class {@code WordHandler} splits a lexeme into words, and
 * it is created a new object for punctuation storing.
 */
public class WordHandler extends AbstractHandler{
    static final String PATTERN_WORD_PUNCT = "\\p{Punct}|[^\\p{Punct}]+";
    static final String PATTERN_PUNCT = "\\p{Punct}";
    static final String PATTERN_WORD = "[^\\p{Punct}]+";
    private AbstractHandler handler = new SymbolHandler();
    @Override
    public void handlerRequest(Composite lexeme, String lexemeText) {
        Pattern pattern = Pattern.compile(PATTERN_WORD_PUNCT);
        Matcher matcher = pattern.matcher(lexemeText);
        while (matcher.find()){
            for(int i = 0;i< matcher.groupCount()+1;i++){
                if(matcher.group(i).matches(PATTERN_WORD)){
                    Composite word = new CompositeImpl(TypeComponent.WORD);
                    lexeme.add(word);
                    handler.handlerRequest(word,matcher.group(i));
                }else if(matcher.group(i).matches(PATTERN_PUNCT)){
                    LeafSymbol punct = new LeafSymbol(matcher.group(i).charAt(i), TypeComponent.PUNCT);
                    lexeme.add(punct);
                }
            }
        }
    }
}
