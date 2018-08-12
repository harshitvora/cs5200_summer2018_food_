package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RestaurantDao {
    
    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int id, Restaurant newAdress) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isPresent()) {
            Restaurant restaurant = optional.get();
            restaurant.set(newAdress);
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }

    public void deleteAllRestaurantes() {
        restaurantRepository.deleteAll();
    }

    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }
}
