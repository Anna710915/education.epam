package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.ComponentImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler{
    static final String REGEX_SENTENCE = "(?:<(?:(?:[a-z]+\\s(?:[^>=]|='[^']*'|=\"[^\"]*\"|=[^'\"\\s]*)*\"\\s?\\/?|\\/[a-z]+)>)|(?:(?!<)(?:[^.?!]|[.?!](?=\\S)))*)+[.?!]";
    private AbstractHandler handler = new LexemeHandler();
    @Override
    public void handlerRequest(Component paragraph, String paragraphText) {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(paragraphText);
        while (matcher.find()){
            for( int groupIdx = 0; groupIdx < matcher.groupCount()+1; groupIdx++ ){
                Component sentence = new ComponentImpl();
                paragraph.add(sentence);
                handler.handlerRequest(sentence,matcher.group(groupIdx));
            }
        }
    }
}
