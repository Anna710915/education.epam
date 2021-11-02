package by.epam.taskfourth.chain;

import by.epam.taskfourth.composite.Component;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractHandler {
    public abstract void handlerRequest(Component component, String element);
}
