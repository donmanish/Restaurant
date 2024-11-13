package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Payment extends BaseModel {
    @ManyToOne
    private User user;
    @Enumerated
    private PaymentStatus paymentStatus;

    @OneToOne
    private Bill billing;
}
