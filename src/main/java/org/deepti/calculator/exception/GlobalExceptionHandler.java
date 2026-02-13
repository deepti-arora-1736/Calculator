package org.deepti.calculator.exception;

import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ResponseDTO> handleDivisionByZero(ArithmeticException ex) {
        log.warn("handleDivisionByZero: {}",ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Cannot divide by zero",false), HttpStatus.BAD_REQUEST);
    }

    //executed when @Valid fails
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleInvalidArgs(MethodArgumentNotValidException ex) {
        log.warn("handleInvalidArgs: {}",ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Wrong Input",false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleJsonParseError(HttpMessageNotReadableException ex) {
        log.warn("handleJsonParseError: {}",ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Invalid Parameter",false), HttpStatus.BAD_REQUEST);
    }
/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGeneralException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Internal Server Error",false), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}

