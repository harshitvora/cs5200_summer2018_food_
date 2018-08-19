package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    @Query("from Restaurant r where r.manager.id=:managerId")
    public Optional<Restaurant> findByManagerId(@Param("managerId") int managerId);
}
