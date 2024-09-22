package edu.miu.cs.cs425.finalproject.carmanagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull(message = "* Customer Number is required")
    @Column(name = "customerNumber", nullable = false, unique = true)
    private String customerNumber;

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

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Customer(){

    }
    public Customer(String customerNumber, String name, String email, String password, String phoneNumber, String address) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
