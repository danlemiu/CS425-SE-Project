package edu.miu.cs.cs425.finalproject.carmanagement.controller;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Car;
import edu.miu.cs.cs425.finalproject.carmanagement.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> displayCars() {
        return carService.readAll();
    }

    @PostMapping
    public Car addCar(@RequestBody @Valid Car car) {
        return carService.create(car);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carService.delete(carId);
    }

    @PutMapping("/{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody @Valid Car car) {
        car.setCarId(carId);
        return carService.update(car);
    }

    @GetMapping("/{carId}")
    public Car getCar(@PathVariable Long carId) {
        return carService.readOne(carId);
    }
}
