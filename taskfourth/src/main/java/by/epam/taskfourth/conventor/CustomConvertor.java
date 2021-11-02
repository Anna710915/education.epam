package by.epam.taskfourth.conventor;

import java.util.Iterator;
import java.util.List;

public class CustomConvertor {
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
