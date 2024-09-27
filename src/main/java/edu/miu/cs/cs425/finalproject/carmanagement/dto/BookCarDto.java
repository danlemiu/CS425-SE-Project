package edu.miu.cs.cs425.finalproject.carmanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookCarDto {

    private Long userId;

    private Long carId;

    private LocalDate endDate;
}
