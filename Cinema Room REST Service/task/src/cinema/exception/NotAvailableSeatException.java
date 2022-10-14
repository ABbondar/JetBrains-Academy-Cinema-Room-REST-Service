package cinema.exception;

public class NotAvailableSeatException extends RuntimeException {
    public NotAvailableSeatException(String message) {
        super(message);
    }
}