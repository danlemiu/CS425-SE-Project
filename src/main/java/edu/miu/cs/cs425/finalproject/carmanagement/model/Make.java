package edu.miu.cs.cs425.finalproject.carmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "makes")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeId;

    @NotBlank(message = "* Name is required")
    @Column(nullable = false, unique = true)
    private String makeName;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL)
    List<CarModel> carModels = new ArrayList();

    public Make() {

    }
    public Make(@NotBlank(message = "* Make is required") String makeName, List<CarModel> carModels) {
        super();
        this.makeName = makeName;
        this.carModels = carModels;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }
}
