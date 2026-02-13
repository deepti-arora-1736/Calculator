package org.deepti.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private Double result;
    private String message;
    private boolean success;

}
