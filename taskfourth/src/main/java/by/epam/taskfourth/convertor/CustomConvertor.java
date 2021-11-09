package by.epam.taskfourth.convertor;

import java.util.Iterator;
import java.util.List;

/**
 * Class {@code CustomConvertor} contains a method that
 * turns a list of elements into the text.
 */
public class CustomConvertor {
    /**
     *
     * @param elements is a list of strings
     * @return the string text
     */
    public String makeText(List<String> elements){
        StringBuilder builder = null;

        Iterator<String> iterator = elements.iterator();
        if(iterator.hasNext()){
            builder = new StringBuilder(iterator.next());
            while(iterator.hasNext()){
                builder.append('\n').append(iterator.next());
            }
        }
        return builder.toString();
    }
}
