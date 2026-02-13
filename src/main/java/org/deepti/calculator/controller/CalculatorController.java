package org.deepti.calculator.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepti.calculator.dto.RequestDTO;
import org.deepti.calculator.dto.ResponseDTO;
import org.deepti.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> add(@RequestBody RequestDTO requestDTO){
        log.info("Adding {}", requestDTO);
        Double result=calculatorService.add(requestDTO);
        log.info("Added Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/subtract")
    public ResponseEntity<ResponseDTO> subtract(@RequestBody RequestDTO requestDTO){
        log.info("Subtracting {}", requestDTO);
        Double result=calculatorService.subtract(requestDTO);
        log.info("Subtracted Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/multiply")
    public ResponseEntity<ResponseDTO> multiply(@RequestBody RequestDTO requestDTO){
        log.info("Multiplying {}",requestDTO);
        Double result=calculatorService.multiply(requestDTO);
        log.info("Multiplication Successful");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/divide")
    public ResponseEntity<ResponseDTO> divide(@RequestBody RequestDTO requestDTO){
        log.info("Dividing {} ",requestDTO);
        Double result=calculatorService.divide(requestDTO);
        log.info("Divided Successfully");
        ResponseDTO response=new ResponseDTO(result,"Successful",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
