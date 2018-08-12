package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
