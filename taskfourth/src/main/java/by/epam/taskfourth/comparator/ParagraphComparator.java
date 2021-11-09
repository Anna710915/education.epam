package by.epam.taskfourth.comparator;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;

import java.util.Comparator;

/**
 * Class {@code ParagraphComparator} implements interface Comparator<T> for
 * comparing two objects by their sizes.
 */
public class ParagraphComparator implements Comparator<Composite> {
    @Override
    public int compare(Composite o1, Composite o2) {
        CompositeImpl element1 = (CompositeImpl)o1;
        CompositeImpl element2 = (CompositeImpl)o2;
        int size1 = element1.getComposites().size();
        int size2 = element2.getComposites().size();
        return Integer.compare(size1,size2);
    }
}
