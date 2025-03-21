package com.JobPortal.Job_Portal.controller;

import com.JobPortal.Job_Portal.model.Review;
import com.JobPortal.Job_Portal.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
