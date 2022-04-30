package com.example.quizback.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceRESTApi extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            UserAlreadyExist ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User alreay present with username");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
