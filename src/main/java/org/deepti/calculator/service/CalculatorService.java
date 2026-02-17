package org.deepti.calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.Operation;
import org.deepti.calculator.dto.RequestDTO;
import org.deepti.calculator.entity.Calculation;
import org.deepti.calculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculationRepository calculationRepository;

    public Double calculate(RequestDTO requestDTO) {

        log.info("Calculate(Service)");

        Operation operation=requestDTO.getOperation();
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

        log.info("Saving to database");

        Calculation calculation = new Calculation();
        calculation.setA(requestDTO.getA());
        calculation.setB(requestDTO.getB());
        calculation.setOperation(operation);
        calculation.setResult(result);

        calculationRepository.save(calculation);

        log.info("saved and now returning result");

        return result;

    }

    public List<Calculation> getByOperation(Operation operation) {
        log.info("Fetching calculations for operation: {}", operation);
        return calculationRepository.findByOperation(operation);
    }


}
