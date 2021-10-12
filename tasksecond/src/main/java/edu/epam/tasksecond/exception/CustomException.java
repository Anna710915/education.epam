package edu.epam.tasksecond.exception;

/**
 * Class {code CustomException} contains constructors to
 * generate errors. It inherits methods of the superclass Exception.
 */
public class CustomException extends Exception {
    public CustomException(){}
    public CustomException(String message){
        super(message);
    }
    public CustomException(Throwable cause){
        super(cause);
    }
    public CustomException(String message, Throwable cause){
        super(message, cause);
    }
}
