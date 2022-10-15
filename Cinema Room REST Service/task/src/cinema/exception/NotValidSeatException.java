package cinema.exception;

public class NotValidSeatException extends RuntimeException {
    public NotValidSeatException(String message) {
        super(message);
    }
}