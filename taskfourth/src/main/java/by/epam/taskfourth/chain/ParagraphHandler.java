package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.TypeComponent;

/**
 * Class {@code ParagraphHandler} splits a text into paragraphs.
 */
public class ParagraphHandler extends AbstractHandler{
    static final String DELIMITER_PARAGRAPH = "\\s{4}|\t";
    AbstractHandler handler = new SentenceHandler();
    @Override
    public void handlerRequest(Composite composite, String text) {
        text=text.trim();
        String[] paragraphs = text.split(DELIMITER_PARAGRAPH);
        for(String paragraphText:paragraphs) {
            Composite paragraph = new CompositeImpl(TypeComponent.PARAGRAPH);
            composite.add(paragraph);
            handler.handlerRequest(paragraph,paragraphText);
        }

    }
}
