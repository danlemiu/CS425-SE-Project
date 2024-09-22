package edu.miu.cs.cs425.finalproject.carmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "carmodels")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carModelId;

    @NotBlank(message = "* Model name is require")
    @Column(nullable = false, unique = true)
    private String carModelName;

    @ManyToOne
    @JoinColumn(name = "make_id", nullable = false)
    private Make make;

    public CarModel() {

    }

    public CarModel(@NotBlank(message = "* Model is required") String carModelName, Make make) {
        super();
        this.carModelName = carModelName;
        this.make = make;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }
}
