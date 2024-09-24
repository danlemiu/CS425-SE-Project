package edu.miu.cs.cs425.finalproject.carmanagement.repository;

import edu.miu.cs.cs425.finalproject.carmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
