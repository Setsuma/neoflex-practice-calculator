package ru.neoflex.practice.service;

import ru.neoflex.practice.dto.CalculationResultResponseDto;

import java.util.List;

public interface CalcService {

    public Long add(Integer summand, Integer addend);

    public Long subtract(Integer minuend, Integer subtrahend);

    public List<CalculationResultResponseDto> getHistory();
}