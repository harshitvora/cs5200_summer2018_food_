package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.RestaurantDao;
import edu.neu.cs5200.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    @GetMapping("/api/restaurant")
    public List<Restaurant> findAllRestaurants() {
        return restaurantDao.findAllRestaurants();
    }

    @GetMapping("/api/restaurant/{restaurantId}")
    public Optional<Restaurant> findRestaurantById(@PathVariable("restaurantId") int id) {
        return restaurantDao.findRestaurantById(id);
    }

    @PostMapping("/api/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantDao.createRestaurant(restaurant);
    }

    @DeleteMapping("/api/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int id) {
        restaurantDao.deleteRestaurant(id);
    }

    @PutMapping("/api/restaurant/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int id, @RequestBody Restaurant newRestaurant) {
        return restaurantDao.updateRestaurant(id, newRestaurant);
    }
}
