package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;
import by.epam.taskfourth.composite.ComponentImpl;


public class ParagraphHandler extends AbstractHandler{
    static final String DELIMITER_PARAGRAPH = "\\s{4}";
    AbstractHandler handler = new SentenceHandler();
    @Override
    public void handlerRequest(Component component, String text) {
        text=text.trim();
        String[] paragraphs = text.split(DELIMITER_PARAGRAPH);
        for(String paragraphText:paragraphs) {
            Component paragraph = new ComponentImpl();
            component.add(paragraph);
            handler.handlerRequest(paragraph,paragraphText);
        }

    }
}
