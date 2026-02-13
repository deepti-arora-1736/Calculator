package org.deepti.calculator.controller;

import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.ResponseDTO;
import org.deepti.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<ResponseDTO> add(@RequestParam Double a, @RequestParam Double b){
        log.info("Adding {} {}",a,b);
        Double result=calculatorService.add(a,b);
        log.info("Added Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/subtract")
    public ResponseEntity<ResponseDTO> subtract(@RequestParam Double a, @RequestParam Double b){
        log.info("Subtracting {} {}",a,b);
        Double result=calculatorService.subtract(a,b);
        log.info("Subtracted Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/multiply")
    public ResponseEntity<ResponseDTO> multiply(@RequestParam Double a, @RequestParam Double b){
        log.info("Multiplying {} {}",a,b);
        Double result=calculatorService.multiply(a,b);
        log.info("Multiplication Successful");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/divide")
    public ResponseEntity<ResponseDTO> divide(@RequestParam Double a, @RequestParam Double b){
        log.info("Dividing {} {}",a,b);
        Double result=calculatorService.divide(a,b);
        log.info("Divided Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
