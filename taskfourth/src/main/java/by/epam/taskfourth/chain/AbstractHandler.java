package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Composite;

/**
 * Abstract class {@code AbstractHandler} contains only one method that
 * will override by subclasses.
 */
public abstract class AbstractHandler {
    /**
     * This method are overridden by subclasses to split the text into parts.
     * @param composite the object where stores parts of a text
     * @param element the string that has some information for storing
     */
    public abstract void handlerRequest(Composite composite, String element);
}
