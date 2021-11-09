package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.TypeComponent;
/**
 * Class {@code LexemeHandler} splits a sentence into lexemes.
 */
public class LexemeHandler extends AbstractHandler{
    static final String REGEX_LEXEME = "\\s";
    private AbstractHandler handler = new WordHandler();
    @Override
    public void handlerRequest(Composite sentence, String sentenceText) {
        sentenceText = sentenceText.trim();
        String[] lexemes = sentenceText.split(REGEX_LEXEME);
        for(int i = 0; i < lexemes.length;i++){
            Composite lexeme = new CompositeImpl(TypeComponent.LEXEME);
            sentence.add(lexeme);
            handler.handlerRequest(lexeme,lexemes[i]);
        }
    }
}
