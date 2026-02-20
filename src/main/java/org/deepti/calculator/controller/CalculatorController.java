package org.deepti.calculator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.Operation;
import org.deepti.calculator.dto.RequestDTO;
import org.deepti.calculator.dto.ResponseDTO;
import org.deepti.calculator.entity.Calculation;
import org.deepti.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;


    @PostMapping("/calculate")
    public ResponseEntity<ResponseDTO> calculate(@Valid @RequestBody RequestDTO requestDTO){
        log.info("Calculator (Controller)");
        Double result = calculatorService.calculate(requestDTO);
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getOperations/{operation}")
    public ResponseEntity<List<Calculation>> getByOperation(@PathVariable Operation operation) {
        log.info("Fetching calculations for operation: {}", operation);
        List<Calculation> result = calculatorService.getByOperation(operation);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getOperations")
    public ResponseEntity<List<Calculation>> getOperations() {
        log.info("Fetching calculations for operation: ");
        List<Calculation> result = calculatorService.getAllOperations();
        return ResponseEntity.ok(result);
    }

}
