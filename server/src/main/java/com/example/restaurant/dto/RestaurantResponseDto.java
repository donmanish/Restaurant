package com.example.restaurant.dto;

import com.example.restaurant.model.Restaurant;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class RestaurantResponseDto {
    private List<Restaurant> restaurants;
    private HttpStatus  httpStatus;
    private String message;
}
