package by.epam.taskfourth.composite;

public interface Component {
    void operation();
    boolean add(Component component);
    boolean remove(Component component);
}
