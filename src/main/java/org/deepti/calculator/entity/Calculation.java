package org.deepti.calculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.deepti.calculator.dto.Operation;

@Entity
@Data
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double a;

    private Double b;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    private Double result;
}
