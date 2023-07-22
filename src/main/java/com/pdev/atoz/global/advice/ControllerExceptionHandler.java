//package com.pdev.atoz.global.advice;
//
//import jakarta.validation.ConstraintViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.NoSuchElementException;
//
//
//@RestControllerAdvice
//public class ControllerExceptionHandler {
//
//    @ExceptionHandler(value = {NoSuchElementException.class})
//    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(value = {IllegalArgumentException.class})
//    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(value = {ConstraintViolationException.class})
//    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleException(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//}
