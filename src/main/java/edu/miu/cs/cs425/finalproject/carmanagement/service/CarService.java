package edu.miu.cs.cs425.finalproject.carmanagement.service;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Car;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.CarModelRepository;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.CarRepository;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.DealerRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends BaseService<Car, Long, CarRepository> {

    private final CarModelRepository carModelRepository;

    private final DealerRepository dealerRepository;

    protected CarService(CarRepository repository, CarModelRepository carModelRepository, DealerRepository dealerRepository) {
        super(repository);
        this.carModelRepository = carModelRepository;
        this.dealerRepository = dealerRepository;
    }

    @Override
    public Car create(Car entity) {
        carModelRepository.save(entity.getModel());
        var dealer = dealerRepository.findById(entity.getDealer().getDealerId()).orElseThrow();
        entity.setDealer(dealer);
        return super.create(entity);
    }
}
