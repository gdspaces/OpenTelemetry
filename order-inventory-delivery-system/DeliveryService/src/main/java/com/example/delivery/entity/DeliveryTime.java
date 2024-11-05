package com.example.delivery.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_time")
public class DeliveryTime {

    @Id
    private String postalCode;
    private int days;

    // Getters and Setters
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
