package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.TypeComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class {@code SentenceHandler} splits a paragraph into sentences.
 */
public class SentenceHandler extends AbstractHandler{
    static final String PATTERN_SENTENCE = "(?:<(?:(?:[a-z]+\\s(?:[^>=]|='[^']*'|=\"[^\"]*\"|=[^'\"\\s]*)*\"\\s?\\/?|\\/[a-z]+)>)|(?:(?!<)(?:[^.?!]|[.?!](?=\\S)))*)+[.?!]";
    private AbstractHandler handler = new LexemeHandler();
    @Override
    public void handlerRequest(Composite paragraph, String paragraphText) {
        Pattern pattern = Pattern.compile(PATTERN_SENTENCE);
        Matcher matcher = pattern.matcher(paragraphText);
        while (matcher.find()){
            for( int groupIdx = 0; groupIdx < matcher.groupCount()+1; groupIdx++ ){
                Composite sentence = new CompositeImpl(TypeComponent.SENTENCE);
                paragraph.add(sentence);
                handler.handlerRequest(sentence,matcher.group(groupIdx));
            }
        }
    }
}
