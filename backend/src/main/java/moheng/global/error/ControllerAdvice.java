package moheng.global.error;

import moheng.global.error.dto.ErrorResponse;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleRunTimeException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
