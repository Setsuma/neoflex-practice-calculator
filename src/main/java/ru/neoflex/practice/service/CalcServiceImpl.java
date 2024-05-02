package ru.neoflex.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.practice.dto.CalculationResultResponseDto;
import ru.neoflex.practice.model.CalculationResult;
import ru.neoflex.practice.model.Operation;
import ru.neoflex.practice.repository.CalculationResultRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CalculationResultResponseDto> getHistory() {
        return repository.findAll().stream()
                .map(calculationResult -> new CalculationResultResponseDto(
                        calculationResult.getFirstNumber() + " " +
                                calculationResult.getOperation().label + " " +
                                calculationResult.getSecondNumber(),
                        calculationResult.getResult()))
                .collect(Collectors.toList());
    }
}