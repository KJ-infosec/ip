package kj;
/**
 * Represents a custom exception specific to the KJ chatbot application.
 */
public class KjException extends Exception {
    public KjException(String errorMessage) {
        super(errorMessage);
    }
}
