package com.JobPortal.Job_Portal.controller;

import com.JobPortal.Job_Portal.model.Review;
import com.JobPortal.Job_Portal.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews(@PathVariable Long companyId){
        return reviewService.getAllReviews(companyId);
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review, @PathVariable Long companyId){
        return reviewService.addReview(review,companyId);
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId){
        return reviewService.getReviewById(companyId,reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public Review updateReview(@PathVariable Long companyId,@PathVariable Long reviewId, @RequestBody Review reviewbody){
        return reviewService.updateReview(companyId,reviewId,reviewbody);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        reviewService.deleteReview(companyId,reviewId);
    }
}
