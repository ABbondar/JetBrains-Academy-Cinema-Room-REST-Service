package cinema.exception;

import cinema.dto.exception.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAvailableSeatException.class)
    public ResponseEntity<ExceptionDto> handleNotAvailableSeatException(NotAvailableSeatException ex) {

        log.error("Handler 'NotAvailableSeatException' catch 'NotAvailableSeatException'");
        ExceptionDto exception = new ExceptionDto(ex.getMessage());

        ExceptionDto e = new ExceptionDto(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidSeatException.class)
    public ResponseEntity<ExceptionDto> handleNotValidSeatException(NotValidSeatException ex) {

        log.error("Handler 'NotValidSeatException' catch 'NotValidSeatException'");
        ExceptionDto exception = new ExceptionDto(ex.getMessage());

        ExceptionDto e = new ExceptionDto(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidTokenException.class)
    public ResponseEntity<ExceptionDto> handleNotValidTokenException(NotValidTokenException ex) {

        log.error("Handler 'NotValidTokenException' catch 'NotValidTokenException'");
        ExceptionDto exception = new ExceptionDto(ex.getMessage());

        ExceptionDto e = new ExceptionDto(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}