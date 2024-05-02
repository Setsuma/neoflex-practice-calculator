package ru.neoflex.practice.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class CalcExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError MethodArgumentExceptionHandler(final Exception ex) {
        log.error("MethodArgument exception: {}.", ex.getMessage());
        return ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .reason("The required arguments are not a numbers or go beyond the size")
                .message(ex.getMessage())
                .build();
    }

    @Builder
    @Getter
    public static class ApiError {
        private HttpStatus status;
        private String reason;
        private String message;

        @Builder.Default
        private LocalDateTime timestamp = LocalDateTime.now();
    }
}