package com.first_crud.api.app.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    //EXCEPTION HANDLING METHOD
//Global Exception Handler
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({
            StringIndexOutOfBoundsException.class, IndexOutOfBoundsException.class,
            ArrayIndexOutOfBoundsException.class, ArithmeticException.class, AbstractMethodError.class,
            NumberFormatException.class, IllegalStateException.class, IOException.class, FileNotFoundException.class,
            SQLException.class, ClassNotFoundException.class, InterruptedException.class, ParseException.class,
            OutOfMemoryError.class, UserNotFoundException.class
    })
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception exception){

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE",exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS", HttpStatus.BAD_REQUEST);
        errorResponse.put("ERROR","Bad Request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Global REST API error
    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class, MethodArgumentNotValidException.class,
            SQLIntegrityConstraintViolationException.class, HttpMessageNotReadableException.class,
            HttpRequestMethodNotSupportedException.class, MethodArgumentNotValidException.class, HttpClientErrorException.MethodNotAllowed.class,

    })
    public ResponseEntity<Map<String, Object>> handleRESTGlobalException( Exception exception){

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE",exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS", HttpStatus.METHOD_NOT_ALLOWED);
        errorResponse.put("ERROR","Bad HTTP Request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException( IllegalArgumentException exception){

        logger.error("Invalid Argument Value found please hek the feilds key should be id, name, email and values", exception);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE",exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS",HttpStatus.BAD_REQUEST);
        errorResponse.put("ERROR","Bad Request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, Object>> handleNullPointerException(NullPointerException exception){

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE",exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS", HttpStatus.BAD_REQUEST);
        errorResponse.put("ERROR","Bad Request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
