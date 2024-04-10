package model.exception;

public class FamilyTreeException extends Exception {

    public FamilyTreeException(String message) {
        super(message);
    }

    public FamilyTreeException(String message, Throwable cause) {
        super(message, cause);
    }
}