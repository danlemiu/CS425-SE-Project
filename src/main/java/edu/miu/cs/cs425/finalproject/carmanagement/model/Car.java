package edu.miu.cs.cs425.finalproject.carmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "cars")
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
    @JoinColumn(name = "make_id", nullable = false)
    private Make make;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CarModel model;

    @ManyToOne
    @JoinColumn(name = "condition_id", nullable = false)
    private Condition condition;

    @ManyToOne
    @JoinColumn(name = "style_id", nullable = false)
    private Style style;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;
}
