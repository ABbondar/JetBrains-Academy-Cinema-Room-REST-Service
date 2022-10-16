package cinema.exception;

public class NotValidPasswordKeyException extends RuntimeException {
    public NotValidPasswordKeyException(String message) {
        super(message);
    }
}