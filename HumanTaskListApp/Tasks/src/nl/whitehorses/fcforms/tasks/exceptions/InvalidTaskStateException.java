package nl.whitehorses.fcforms.tasks.exceptions;


public class InvalidTaskStateException extends Exception {
    
    /**
     * Constructor.
     * 
     * @param message
     */
    public InvalidTaskStateException(String message) {
    
        super(message);
    }
}
