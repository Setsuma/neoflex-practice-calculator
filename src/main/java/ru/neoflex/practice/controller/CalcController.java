package ru.neoflex.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.service.CalcService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CalcController {
    private final CalcService service;

    @GetMapping("/plus/{a}/{b}")
    public ResponseEntity<Long> add(@PathVariable Integer a, @PathVariable Integer b) {
        log.info("Add request: summand = {}, addend = {}", a, b);
        return ResponseEntity.ok(service.add(a, b));
    }

    @GetMapping("/minus/{a}/{b}")
    public ResponseEntity<Long> subtract(@PathVariable Integer a, @PathVariable Integer b) {
        log.info("Subtract request: minuend = {}, subtrahend = {}", a, b);
        return ResponseEntity.ok(service.subtract(a, b));
    }
}