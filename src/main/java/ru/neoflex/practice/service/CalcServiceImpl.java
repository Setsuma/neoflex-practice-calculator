package ru.neoflex.practice.service;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public Long add(Integer summand, Integer addend) {
        return (long) (summand + addend);
    }

    @Override
    public Long subtract(Integer minuend, Integer subtrahend) {
        return (long) (minuend - subtrahend);
    }
}