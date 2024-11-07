package com.example.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;



@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;
    @Enumerated
    private UserType userType;
}
