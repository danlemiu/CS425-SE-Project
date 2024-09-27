package edu.miu.cs.cs425.finalproject.carmanagement.service;

import edu.miu.cs.cs425.finalproject.carmanagement.dto.BookCarDto;
import edu.miu.cs.cs425.finalproject.carmanagement.model.CarBooking;
import edu.miu.cs.cs425.finalproject.carmanagement.model.Status;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.CarBookingRepository;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.CarRepository;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarBookingService {

    private final CarBookingRepository carBookingRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public CarBooking createBooking(BookCarDto bookCarDto) {
        CarBooking carBooking = new CarBooking();
        var car = carRepository.findById(bookCarDto.getCarId()).orElseThrow();

        if (Status.NOT_AVAILABLE.equals(car.getStatus())) {
            throw new RuntimeException("Car is not available");
        }

        car.setStatus(Status.NOT_AVAILABLE);
        carRepository.save(car);

        carBooking.setCar(car);
        carBooking.setUsers(List.of());
        carBooking.setEndDate(bookCarDto.getEndDate());
        carBooking.setStartDate(LocalDate.now());
        carBooking.setUsers(List.of(userRepository.findById(bookCarDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"))));
        return carBookingRepository.save(carBooking);
    }
}
