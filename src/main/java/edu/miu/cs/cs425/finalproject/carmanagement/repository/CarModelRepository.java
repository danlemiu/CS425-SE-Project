package edu.miu.cs.cs425.finalproject.carmanagement.repository;

import edu.miu.cs.cs425.finalproject.carmanagement.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
