package ru.neoflex.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.practice.model.CalculationResult;
import ru.neoflex.practice.model.Operation;
import ru.neoflex.practice.repository.CalculationResultRepository;

@Service
@RequiredArgsConstructor
public class CalcServiceImpl implements CalcService {
    private final CalculationResultRepository repository;

    @Override
    public Long add(Integer summand, Integer addend) {
        long result = (long) (summand + addend);
        repository.save(CalculationResult.builder()
                .firstNumber(summand)
                .secondNumber(addend)
                .operation(Operation.ADD)
                .result(result)
                .build());
        return result;
    }

    @Override
    public Long subtract(Integer minuend, Integer subtrahend) {
        long result = (long) (minuend - subtrahend);
        repository.save(CalculationResult.builder()
                .firstNumber(minuend)
                .secondNumber(subtrahend)
                .operation(Operation.SUBTRACT)
                .result(result)
                .build());
        return result;
    }
}