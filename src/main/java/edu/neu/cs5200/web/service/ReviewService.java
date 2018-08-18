package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.ReviewDao;
import edu.neu.cs5200.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;

    @GetMapping("/api/review")
    public List<Review> findAllReviews() {
        return reviewDao.findAllReviews();
    }

    @GetMapping("/api/review/{reviewId}")
    public Optional<Review> findReviewById(@PathVariable("reviewId") int id) {
        return reviewDao.findReviewById(id);
    }

    @GetMapping("/api/review/restaurant/{restaurantId}")
    public List<Review> findReviewByRestaurantId(@PathVariable("restaurantId") int id) {
        return reviewDao.findReviewByRestaurantId(id);
    }

    @GetMapping("/api/review/user/{userId}")
    public List<Review> findReviewByUserId(@PathVariable("userId") int id) {
        return reviewDao.findReviewByUserId(id);
    }

    @PostMapping("/api/review")
    public Review createReview(@RequestBody Review review, @RequestParam("cid") int customerId, @RequestParam("rid") int restaurantId) {
        return reviewDao.createReview(review, customerId, restaurantId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int id) {
        reviewDao.deleteReview(id);
    }

    @PutMapping("/api/review/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int id, @RequestBody Review newReview) {
        return reviewDao.updateReview(id, newReview);
    }
}
