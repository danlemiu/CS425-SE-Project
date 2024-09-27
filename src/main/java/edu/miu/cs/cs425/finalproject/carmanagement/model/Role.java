package edu.miu.cs.cs425.finalproject.carmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
