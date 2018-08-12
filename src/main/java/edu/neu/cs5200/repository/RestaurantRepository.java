package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
