package ru.neoflex.practice.calc.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import ru.neoflex.practice.controller.CalcController;
import ru.neoflex.practice.service.CalcService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcControllerUnitTest {
    CalcController calcController;
    CalcService mockCalcService;

    @BeforeAll
    void setUp() {
        mockCalcService = Mockito.mock(CalcService.class);
        calcController = new CalcController(mockCalcService);
        ;
    }

    @Test
    void addTest() {
        when(mockCalcService.add(anyInt(), anyInt())).thenReturn(1L);
        assertEquals(1, calcController.add(0, 1).getBody());
    }

    @Test
    void subtractTest() {
        when(mockCalcService.subtract(anyInt(), anyInt())).thenReturn(1L);
        assertEquals(1, calcController.subtract(2, 1).getBody());
    }
}