package com.example.restaurant.dto;

import com.example.restaurant.model.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ItemResponseData{
    private List<Item> item;
    private HttpStatus status;
    private String message;
}
