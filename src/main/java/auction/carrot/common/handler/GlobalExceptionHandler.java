package auction.carrot.common.handler;

import auction.carrot.common.exception.TechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TechnicalException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(TechnicalException e) {
        final ErrorResponse response = ErrorResponse
                .builder(e.getCause()
                        , HttpStatus.INTERNAL_SERVER_ERROR
                        , e.getMessage())
                .build();
        log.error("TechnicalException = {}", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
