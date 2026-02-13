package org.deepti.calculator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Double divide(Double a, Double b) {
        if (b == 0) {
            log.warn("Attempted to divide by zero {} {}",a,b);
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
