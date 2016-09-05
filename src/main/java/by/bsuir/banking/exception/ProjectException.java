package by.bsuir.banking.exception;

/**
 * Parent class for all exception classes in project.
 */
public class ProjectException extends Exception {
    private static final long serialVersionUID = 1;
    private Exception hiddenException;

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Exception e) {
        super(message);
        hiddenException = e;
    }

    public Exception getHiddenException() {
        return hiddenException;
    }
}
