package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;


public class TextHandler extends AbstractHandler{
    private AbstractHandler handler = new ParagraphHandler();
    @Override
    public void handlerRequest(Component component, String elements) {
        handler.handlerRequest(component,elements);
    }
}
