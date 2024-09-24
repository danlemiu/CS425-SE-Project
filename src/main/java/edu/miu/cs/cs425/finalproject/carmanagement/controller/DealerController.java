package edu.miu.cs.cs425.finalproject.carmanagement.controller;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Car;
import edu.miu.cs.cs425.finalproject.carmanagement.model.Dealer;
import edu.miu.cs.cs425.finalproject.carmanagement.service.DealerService;
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
@RequestMapping("/dealers")
@RequiredArgsConstructor
public class DealerController {


    private final DealerService dealerService;

    @GetMapping
    public List<Dealer> readDealer() {
        return dealerService.readAll();
    }

    @PostMapping
    public Dealer addDealer(@RequestBody Dealer dealer) {
        return dealerService.create(dealer);
    }

    @GetMapping("/{dealerId}")
    public Dealer getDealer(@PathVariable Long dealerId) {
        return dealerService.readOne(dealerId);
    }

    @PutMapping("/{dealerId}")
    public Dealer updateDealer(@PathVariable Long dealerId, @RequestBody @Valid Dealer dealer) {
        dealer.setDealerId(dealerId);
        return dealerService.update(dealer);
    }

    @GetMapping("/{dealerId}/cars")
    public List<Car> getDealerCars(@PathVariable Long dealerId) {
        return dealerService.readOne(dealerId).getCars();
    }

    @DeleteMapping("/{dealerId}")
    public void deleteDealer(@PathVariable Long dealerId) {
        dealerService.delete(dealerId);
    }
}
