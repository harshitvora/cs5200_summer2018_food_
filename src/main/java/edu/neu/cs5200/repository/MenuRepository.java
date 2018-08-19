package edu.neu.cs5200.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

    @Query("from Menu m where m.restaurant.id=:restaurantId")
    public List<Menu> findMenuByRestaurantId(@Param("restaurantId") int restaurantId);

}
