package edu.miu.cs.cs425.finalproject.carmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "dealers")
@Data
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealerId;

    @NotNull(message = "* Dealer Number is required")
    @Column(name = "dealerNumber", nullable = false)
    private String dealerNumber;

    @NotNull(message = "* Name is required")
    @NotBlank(message = "* Name cannot be empty or blank space(s)")
    private String name;

    @NotNull(message = "* Email is required")
    @NotBlank(message = "* Email cannot be empty or blank space(s)")
    private String email;

    @NotNull(message = "* Password is required")
    @NotBlank(message = "* Password cannot be empty or blank space(s)")
    private String password;

    @NotNull(message = "* Phone Number is required")
    @NotBlank(message = "* Phone Number cannot be empty or blank space(s)")
    private String phoneNumber;

    @NotNull(message = "* Address is required")
    @NotBlank(message = "* Address cannot be empty or blank space(s)")
    private String address;

    private String website;

    @OneToMany(mappedBy = "dealer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Car> cars;
}
