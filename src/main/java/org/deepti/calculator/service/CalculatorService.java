package org.deepti.calculator.service;

import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.RequestDTO;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public Double add(RequestDTO requestDTO) {
        return requestDTO.getA() + requestDTO.getB();
    }

    public Double subtract(RequestDTO requestDTO) {
        return requestDTO.getA() - requestDTO.getB();
    }

    public Double multiply(RequestDTO requestDTO) {
        return requestDTO.getA() * requestDTO.getB();
    }

    public Double divide(RequestDTO requestDTO) {
        if (requestDTO.getB() == 0) {
            log.warn("Attempted to divide by zero {} {}",requestDTO.getA(),requestDTO.getB());
            throw new ArithmeticException("Cannot divide by zero");
        }
        return requestDTO.getA() / requestDTO.getB();
    }
}
