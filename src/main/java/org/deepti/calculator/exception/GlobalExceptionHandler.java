package org.deepti.calculator.exception;

import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ResponseDTO> handleDivisionByZero(ArithmeticException ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Cannot divide by zero",false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseDTO> handleMissingParams(MissingServletRequestParameterException ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Less parameters",false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseDTO> handleMissingOperation(NullPointerException ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Invalid Operation",false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseDTO> handleInvalidParams(MethodArgumentTypeMismatchException ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Invalid Parameter",false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGeneralException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ResponseDTO(null,"Internal Server Error",false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

