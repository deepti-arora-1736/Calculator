package org.deepti.calculator.repository;

import org.deepti.calculator.entity.Calculation;
import org.deepti.calculator.dto.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationRepository
        extends JpaRepository<Calculation, Long> {

    List<Calculation> findByOperation(Operation operation);
}
