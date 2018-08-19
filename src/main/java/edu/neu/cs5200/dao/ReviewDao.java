package edu.neu.cs5200.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.entity.Review;
import edu.neu.cs5200.entity.User;
import edu.neu.cs5200.repository.RestaurantRepository;
import edu.neu.cs5200.repository.ReviewRepository;
import edu.neu.cs5200.repository.UserRepository;

@Component
public class ReviewDao {
    
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public Review createReview(Review review, int customerId, int restaurantId) {
        Optional<User> customer = userRepository.findById(customerId);
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if(customer.isPresent() && restaurant.isPresent()){
            User customerObject = customer.get();
            Restaurant restaurantObject = restaurant.get();
            review.setRestaurant(restaurantObject);
            review.setCustomer(customerObject);
            customerObject.addReview(review);
            restaurantObject.addReview(review);
            userRepository.save(customerObject);
            restaurantRepository.save(restaurantObject);
            return reviewRepository.save(review);
        }
        return null;
    }

    public Review updateReview(int id, Review newReview) {
        Optional<Review> optional = reviewRepository.findById(id);
        if (optional.isPresent()) {
            Review review = optional.get();
            review.set(newReview);
            return reviewRepository.save(review);
        }
        return null;
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    public void deleteAllReviews() {
        reviewRepository.deleteAll();
    }

    public List<Review> findAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public List<Review> findReviewByRestaurantId(int restaurantId) {
        return  (List<Review>) reviewRepository.findByRestaurantId(restaurantId);
    }

    public List<Review> findReviewByUserId(int userId) {
        return  (List<Review>) reviewRepository.findByUserId(userId);
    }
}
