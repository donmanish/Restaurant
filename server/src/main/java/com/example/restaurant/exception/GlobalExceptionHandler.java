package com.example.restaurant.exception;


import com.example.restaurant.dto.ItemResponseData;
import com.example.restaurant.dto.MenuItemResponseDto;
import com.example.restaurant.dto.RestaurantResponseDto;
import com.example.restaurant.dto.SubItemResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestaurentException.class)
    public  ResponseEntity<RestaurantResponseDto> handleCustomException(RestaurentException ex){
        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto();
        restaurantResponseDto.setHttpStatus(ex.getStatus());
        return new ResponseEntity<>(restaurantResponseDto, ex.getStatus());
    }

    @ExceptionHandler(MenuException.class)
    public  ResponseEntity<MenuItemResponseDto> handleCustomException(MenuException ex){
        MenuItemResponseDto menuItemResponseDto = new MenuItemResponseDto();
        menuItemResponseDto.setStatus(ex.getStatus());
        return new ResponseEntity<>(menuItemResponseDto, ex.getStatus());
    }

    @ExceptionHandler(ItemException.class)
    public  ResponseEntity<ItemResponseData> handleCustomException(ItemException ex){
        ItemResponseData itemResponseDto = new ItemResponseData();
        itemResponseDto.setStatus(ex.getStatus());
        return new ResponseEntity<>(itemResponseDto, ex.getStatus());
    }

    @ExceptionHandler(SubItemException.class)
    public  ResponseEntity<SubItemResponseData> handleCustomException(SubItemException ex){
        SubItemResponseData SubItemResponseDto = new SubItemResponseData();
        SubItemResponseDto.setStatus(ex.getStatus());
        return new ResponseEntity<>(SubItemResponseDto, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
