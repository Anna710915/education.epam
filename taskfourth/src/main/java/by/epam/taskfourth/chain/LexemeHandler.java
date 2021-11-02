package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.ComponentImpl;
import by.epam.taskfourth.composite.LeafSymbol;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler extends AbstractHandler{
    static final String REGEX_LEXEME = " ";
    private AbstractHandler handler = new WordHandler();
    @Override
    public void handlerRequest(Component sentence, String sentenceText) {
        sentenceText = sentenceText.trim();
        String[] lexemes = sentenceText.split(REGEX_LEXEME);
        for(int i = 0; i < lexemes.length;i++){
            Component lexeme = new ComponentImpl();
            sentence.add(lexeme);
            handler.handlerRequest(lexeme,lexemes[i]);
        }
    }
}
