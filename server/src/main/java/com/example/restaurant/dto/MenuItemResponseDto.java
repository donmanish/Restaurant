package com.example.restaurant.dto;

import com.example.restaurant.model.Menu;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class MenuItemResponseDto {
    private List<Menu> menu;
    private HttpStatus status;
    private String message;
}
