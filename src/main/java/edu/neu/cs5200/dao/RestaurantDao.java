package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestaurantDao {
    
    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int id, Restaurant newRestaurant) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isPresent()) {
            Restaurant restaurant = optional.get();
            restaurant.set(newRestaurant);
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

    public Optional<Restaurant> findRestaurantByZomatoId(int zomatoId) {
        return restaurantRepository.findByZomatoId(zomatoId);
    }

//    public List<Restaurant> findRestaurantByLocation(Double latitude, Double longitude) {
//        return (List<Restaurant>) restaurantRepository.findRestaurantByLocation(latitude, longitude);
//    }

}
