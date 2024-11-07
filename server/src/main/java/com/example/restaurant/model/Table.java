package com.example.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "tables")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table extends BaseModel{
    private String Qrcode;
    @ManyToOne
    private User user;
    @Enumerated
    private TableStatus tableStatus;
}
