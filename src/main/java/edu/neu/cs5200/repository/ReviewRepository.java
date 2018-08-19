package edu.neu.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query("from Review r where r.restaurant.id=:restaurantId")
    public Iterable<Review> findByRestaurantId(@Param("restaurantId") int restaurantId);

    @Query("from Review r where r.customer.id=:userId")
    public Iterable<Review> findByUserId(@Param("userId") int userId);
}
