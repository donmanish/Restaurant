package com.example.restaurant.dto;


import com.example.restaurant.model.SubItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class SubItemResponseData{
    private List<SubItem> subitem;
    private HttpStatus status;
    private String message;
}
