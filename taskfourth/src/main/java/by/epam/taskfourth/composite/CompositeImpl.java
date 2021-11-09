package by.epam.taskfourth.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeImpl implements Composite {
    private TypeComponent type;
    private List<Composite> composites = new ArrayList<Composite>();
    public CompositeImpl(){}
    public CompositeImpl(TypeComponent type){//TODO
        this.type = type;
    }

    public List<Composite> getComposites() {
        return composites;
    }

    public void setComposites(List<Composite> composites) {
        this.composites = composites;
    }

    @Override
    public boolean add(Composite composite) {
        return composites.add(composite);
    }

    @Override
    public boolean remove(Composite composite) {
        return composites.remove(composite);
    }

    @Override
    public TypeComponent getTypeComponent() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Composite element: composites){
            String delimiter = element.getTypeComponent().getDelimiter();
            builder.append(element.toString()).append(delimiter);
        }
        return builder.toString();
    }
}
