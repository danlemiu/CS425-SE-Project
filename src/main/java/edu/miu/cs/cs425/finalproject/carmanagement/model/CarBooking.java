package edu.miu.cs.cs425.finalproject.carmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car_bookings")
@Data
public class CarBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Car car;

    @ManyToMany
    private List<User> users;

    @CreatedDate
    private LocalDate startDate;

    private LocalDate endDate;
}
