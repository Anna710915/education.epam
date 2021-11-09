package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;

/**
 * Class {@code TextHandler} has one private field that declares
 * new {@code handler} object. Handler object transfers control
 * to the next class along the chain.
 */
public class TextHandler extends AbstractHandler{
    private AbstractHandler handler = new ParagraphHandler();
    @Override
    public void handlerRequest(Composite composite, String elements) {
        handler.handlerRequest(composite,elements);
    }
}
