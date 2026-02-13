package org.deepti.calculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class RequestDTO {

    @NotNull(message="it cannot be null")
    private Double a;

    @NotNull(message="it cannot be null")
    private Double b;

    @NotNull(message="it cannot be null")
    private Operation operation;


}
