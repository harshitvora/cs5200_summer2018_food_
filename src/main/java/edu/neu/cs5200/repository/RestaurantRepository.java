package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Customer;
import edu.neu.cs5200.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    @Query("from Restaurant r where r.zomatoId=:zomatoId")
    public Iterable<Restaurant> findByZomatoId(@Param("zomatoId") Integer zomatoId);
}
