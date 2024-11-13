package com.example.restaurant.controller;
import com.example.restaurant.dto.RestaurantResponseDto;
import com.example.restaurant.exception.RestaurentException;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.service.MenuService;
import com.example.restaurant.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class RestaurentControler {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    public RestaurentControler(RestaurantService restaurantService, MenuService menuService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
    }

    //create the resturant
    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        try{
            Restaurant restaurent = restaurantService.createRestaurent(restaurant);
            if (restaurent == null) {
                throw  new RestaurentException(HttpStatus.BAD_REQUEST, "restaurant is null");
            }
            return new ResponseEntity<>(restaurent, HttpStatus.CREATED);
        }catch (RuntimeException e){

           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }


    }


    //read Only one resturant
    @GetMapping("/restaurant/{email}")
    public ResponseEntity<Menu> getRestaurantById(@PathVariable("email") String email) {
        try {
            Menu menus = menuService.getAllMenuItemsFromRestaurantName(email);
            return new ResponseEntity<>(menus, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //read All resturant
    @GetMapping("/restaurant")
    public ResponseEntity<RestaurantResponseDto> getAllRestaurant()
    {
        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto();
        List<Restaurant> restaurent = restaurantService.getAllRestaurant();
        restaurantResponseDto.setRestaurants(restaurent);

        if (restaurent.isEmpty() || restaurent.size() == 0 || restaurent == null) {
            restaurantResponseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
            restaurantResponseDto.setMessage("Restaurent not found or null");
        } else {
            restaurantResponseDto.setHttpStatus(HttpStatus.OK);
            restaurantResponseDto.setMessage("Resturant List get successfully");
        }

        return new ResponseEntity<>(restaurantResponseDto, restaurantResponseDto.getHttpStatus());

    }
    //update by id resturant
    @PutMapping("/restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") int restaurantid, @RequestBody Restaurant updaterestaurant) {
     return null;
    }

    //delete by id resturant
    @DeleteMapping("/restaurant/{id}")
    public Restaurant deleteRestaurant(@PathVariable("id") int restaurantid) {
        return null;
    }

}
