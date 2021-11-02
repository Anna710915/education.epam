package by.epam.taskfourth.composite;

import java.util.ArrayList;
import java.util.List;

public class ComponentImpl implements Component{
    private TypeComponent type;
    private List<Component> components = new ArrayList<Component>();
    public ComponentImpl(){}
    public ComponentImpl(TypeComponent type){//TODO
        this.type = type;
    }
    @Override
    public void operation(){

    }
    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public String toString() { //TODO
        String s = "";
        for(Component element:components){
            s = s+element.toString();
        }
        return s;
    }
}
