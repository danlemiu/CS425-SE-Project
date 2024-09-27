package edu.miu.cs.cs425.finalproject.carmanagement.controller;

import edu.miu.cs.cs425.finalproject.carmanagement.dto.BookCarDto;
import edu.miu.cs.cs425.finalproject.carmanagement.model.CarBooking;
import edu.miu.cs.cs425.finalproject.carmanagement.service.CarBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class CarBookingController {

    private final CarBookingService carBookingService;

    @PostMapping("/{carId}")
    public CarBooking bookCar(@PathVariable Long carId, @RequestBody @Valid BookCarDto bookCarDto) {
        bookCarDto.setCarId(carId);
        return carBookingService.createBooking(bookCarDto);
    }
}
