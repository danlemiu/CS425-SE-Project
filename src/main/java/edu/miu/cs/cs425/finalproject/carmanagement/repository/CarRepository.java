package edu.miu.cs.cs425.finalproject.carmanagement.repository;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.status = 'AVAILABLE'")
    List<Car> findAllByStatusIsTrue();
}
