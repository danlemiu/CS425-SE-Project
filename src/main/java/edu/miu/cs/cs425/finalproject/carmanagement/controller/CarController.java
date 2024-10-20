package edu.miu.cs.cs425.finalproject.carmanagement.controller;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Car;
import edu.miu.cs.cs425.finalproject.carmanagement.model.CarModel;
import edu.miu.cs.cs425.finalproject.carmanagement.model.Condition;
import edu.miu.cs.cs425.finalproject.carmanagement.model.Make;
import edu.miu.cs.cs425.finalproject.carmanagement.model.Style;
import edu.miu.cs.cs425.finalproject.carmanagement.service.CarService;
import edu.miu.cs.cs425.finalproject.carmanagement.service.DealerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    private final DealerService dealerService;

    @GetMapping
    public String displayCars(Model model) {
        List<Car> cars = carService.readAll();
        model.addAttribute("cars", cars);
        return "cars/list";
    }

    @GetMapping("/available")
    public String displayAllAvailableCars(Model model) {
        List<Car> availableCars = carService.readAllAvailableCars();
        model.addAttribute("cars", availableCars);
        return "cars/available";
    }

    @GetMapping("/add")
    public String showAddCarForm(Model model) {
        var car = new Car();
        car.setModel(new CarModel());
        model.addAttribute("dealer", dealerService.readAll());
        model.addAttribute("car", car);
        model.addAttribute("styles", Style.values());
        model.addAttribute("makes", Make.values());
        model.addAttribute("conditions", Condition.values());
        return "cars/add";
    }

    @PostMapping
    public String addCar(@ModelAttribute @Valid Car car) {
        carService.create(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable Long carId) {
        carService.delete(carId);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{carId}")
    public String showEditCarForm(@PathVariable Long carId, Model model) {
        Car car = carService.readOne(carId);
        model.addAttribute("dealer", dealerService.readAll());
        model.addAttribute("car", car);
        model.addAttribute("styles", Style.values());
        model.addAttribute("makes", Make.values());
        model.addAttribute("conditions", Condition.values());
        return "cars/edit";
    }

    @PutMapping("/{carId}")
    public String updateCar(@PathVariable Long carId, @ModelAttribute @Valid Car car) {
        car.setCarId(carId);
        carService.update(car);
        return "redirect:/cars";
    }

    @GetMapping("/{carId}")
    public String getCar(@PathVariable Long carId, Model model) {
        Car car = carService.readOne(carId);
        model.addAttribute("car", car);
        return "cars/view";
    }
}