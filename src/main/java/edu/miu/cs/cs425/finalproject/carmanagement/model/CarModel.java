package edu.miu.cs.cs425.finalproject.carmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "carmodels")
@Data
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carModelId;

    @NotBlank(message = "* Model name is require")
    @Column(nullable = false)
    private String carModelName;

    @Enumerated(EnumType.STRING)
    private Make make;

    public CarModel() {
    }

    public CarModel(@NotBlank(message = "* Model is required") String carModelName, Make make) {
        super();
        this.carModelName = carModelName;
        this.make = make;
    }
}
