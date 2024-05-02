package ru.neoflex.practice.calc.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.neoflex.practice.controller.CalcController;
import ru.neoflex.practice.service.CalcService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalcController.class)
@AutoConfigureMockMvc
public class CalcControllerIntegrationTest {
    @MockBean
    CalcService calcService;
    @Autowired
    MockMvc mockMvc;

    @Test
    @SneakyThrows
    void add_WhenAllAreOk_ThenReturnSum() {
        when(calcService.add(anyInt(), anyInt()))
                .thenReturn(1L);

        MvcResult mvcResult = mockMvc.perform(get("/plus/{a}/{b}", 0, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        long response = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(1, response);
    }

    @Test
    @SneakyThrows
    void add_WhenArgumentNotANumber_ThenThrowArgumentException() {
        mockMvc.perform(get("/plus/{a}/{b}", 0, "one")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.reason")
                        .value("The required arguments are not a numbers or go beyond the size"));
    }

    @Test
    @SneakyThrows
    void add_WhenArgumentOutOfBounds_ThenThrowArgumentException() {
        mockMvc.perform(get("/plus/{a}/{b}", 0, 11111111111L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.reason")
                        .value("The required arguments are not a numbers or go beyond the size"));
    }

    @Test
    @SneakyThrows
    void subtract_WhenAllAreOk_ThenReturnDif() {
        when(calcService.subtract(anyInt(), anyInt()))
                .thenReturn(1L);

        MvcResult mvcResult = mockMvc.perform(get("/minus/{a}/{b}", 2, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        long response = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(1, response);
    }

    @Test
    @SneakyThrows
    void subtract_WhenArgumentNotANumber_ThenThrowArgumentException() {
        mockMvc.perform(get("/minus/{a}/{b}", 2, "one")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.reason")
                        .value("The required arguments are not a numbers or go beyond the size"));
    }

    @Test
    @SneakyThrows
    void subtract_WhenArgumentOutOfBounds_ThenThrowArgumentException() {
        mockMvc.perform(get("/minus/{a}/{b}", 2, 11111111111L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.reason")
                        .value("The required arguments are not a numbers or go beyond the size"));
    }
}