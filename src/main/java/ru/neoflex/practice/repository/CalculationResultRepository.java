package ru.neoflex.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.practice.model.CalculationResult;

public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}