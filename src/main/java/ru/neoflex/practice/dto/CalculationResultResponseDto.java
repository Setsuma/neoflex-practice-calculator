package ru.neoflex.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculationResultResponseDto {
    private String expression;
    private long result;
}