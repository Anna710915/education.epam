package by.epam.taskfourth.composite;

import java.util.List;

/**
 * Interface {@code Composite} contains methods that
 * implement basic logic for composite.
 */
public interface Composite {
    /**
     * The method adds components into the composite
     * @param composite is a new component
     * @return true, if the component is added successfully;
     * false otherwise
     */
    boolean add(Composite composite);
    /**
     * The method removes components into the composite
     * @param composite is a component
     * @return true, if the component is removed successfully;
     * false otherwise
     */
    boolean remove(Composite composite);

    /**
     *
     * @return the type of component.
     */
    TypeComponent getTypeComponent();

    /**
     *
     * @return the list of components
     */
    List<Composite> getComposites();
}
