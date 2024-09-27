package edu.miu.cs.cs425.finalproject.carmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    @NotNull(message = "* Price is required")
    @Column(nullable = false)
    private double price;

    @NotNull(message = "* Mileage is required")
    @Column(nullable = false)
    private long mileage;

    @NotNull(message = "* Year is required")
    @Column(nullable = false)
    private int year;

    private String zipCode;

    private LocalDate uploadDate;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CarModel model;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_condition")
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    @Enumerated(EnumType.STRING)
    private Style style;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;
}
