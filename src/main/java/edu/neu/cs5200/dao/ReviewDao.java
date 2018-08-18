package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Review;
import edu.neu.cs5200.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReviewDao {
    
    @Autowired
    ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
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
}
