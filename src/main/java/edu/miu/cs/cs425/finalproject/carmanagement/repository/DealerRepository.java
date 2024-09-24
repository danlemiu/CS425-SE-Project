package edu.miu.cs.cs425.finalproject.carmanagement.repository;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
