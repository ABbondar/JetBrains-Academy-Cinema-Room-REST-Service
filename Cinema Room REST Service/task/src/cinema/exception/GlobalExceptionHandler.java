package cinema.exception;

import cinema.dto.exceptions.ExceptionDto;
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

    @ExceptionHandler(OutOfBoundException.class)
    public ResponseEntity<ExceptionDto> handleOutOfBoundException(OutOfBoundException ex) {

        log.error("Handler 'OutOfBoundException' catch 'OutOfBoundException'");
        ExceptionDto exception = new ExceptionDto(ex.getMessage());

        ExceptionDto e = new ExceptionDto(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}