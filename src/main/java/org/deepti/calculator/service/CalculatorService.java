package org.deepti.calculator.service;

import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.Operation;
import org.deepti.calculator.dto.RequestDTO;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public Double calculate(RequestDTO requestDTO) {

        log.info("Calculate in Service");
        Operation operation=requestDTO.getOperation();
        log.info("Calculate in Service after get");
        Double result=null;

        log.info("Operation : {}",operation);

        switch (operation){

            case ADD -> {
                log.info("ADD");
                result = requestDTO.getA() + requestDTO.getB();
            }
            case SUBTRACT -> {
                log.info("SUBTRACT");
                result = requestDTO.getA() - requestDTO.getB();
            }
            case MULTIPLY -> {
                log.info("MULTIPLY");
                result = requestDTO.getA() * requestDTO.getB();
            }
            case DIVIDE -> {
                log.info("DIVIDE");
                if (requestDTO.getB() == 0) {
                    log.warn("Attempted to divide by zero {} {}",requestDTO.getA(),requestDTO.getB());
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = requestDTO.getA() / requestDTO.getB();
            }
            default -> log.info("invalid");

        }

        log.info("returning result");

        return result;

    }

//    public Double add(RequestDTO requestDTO) {
//        return requestDTO.getA() + requestDTO.getB();
//    }
//
//    public Double subtract(RequestDTO requestDTO) {
//        return requestDTO.getA() - requestDTO.getB();
//    }
//
//    public Double multiply(RequestDTO requestDTO) {
//        return requestDTO.getA() * requestDTO.getB();
//    }
//
//    public Double divide(RequestDTO requestDTO) {
//        if (requestDTO.getB() == 0) {
//            log.warn("Attempted to divide by zero {} {}",requestDTO.getA(),requestDTO.getB());
//            throw new ArithmeticException("Cannot divide by zero");
//        }
//        return requestDTO.getA() / requestDTO.getB();
//    }
}
