package edu.epam.tasksecond.observer;

/**
 * Interface Observable contains methods for subscribing and
 * unsubscribing observers; have a notifyObservers method to notify
 * them about changes in an object.
 */
public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
