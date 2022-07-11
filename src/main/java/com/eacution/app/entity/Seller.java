package com.eacution.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Seller {
    @Id
    @GeneratedValue
    private long sellerId;
    @Size(min = 5, max = 30, message
            = "Seller first name should be min 5 and max 30 characters ")
    @NotNull
    private String firstName;
    @Size(min = 5, max = 25, message
            = "Seller last name should be min 3 and max 25 characters ")
    @NotNull
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int pin;
    @Pattern(regexp="(^$|[0-9]{10})")
    @NotNull
    private String phone;
    @Email
    @NotNull
    private String email;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
