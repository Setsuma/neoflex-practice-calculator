package ru.neoflex.practice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calculation_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calc_id")
    private Long id;

    @Column(name = "first_number", nullable = false)
    private int firstNumber;

    @Column(name = "second_number", nullable = false)
    private int secondNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation", nullable = false)
    private Operation operation;

    @Column(name = "result", nullable = false)
    private long result;
}