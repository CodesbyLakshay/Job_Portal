package com.JobPortal.Job_Portal.service;

import com.JobPortal.Job_Portal.model.Company;
import com.JobPortal.Job_Portal.model.Review;
import com.JobPortal.Job_Portal.repository.CompanyRepository;
import com.JobPortal.Job_Portal.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewService(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;

        this.companyService = companyService;
    }

    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    public Review addReview(Review review, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        review.setCompany(company);
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId);
    }

    public Review updateReview(Long companyId, Long reviewId, Review reviewbody) {
        Review review = reviewRepository.findByIdAndCompanyId(reviewId,companyId);
        review.setTitle(reviewbody.getTitle());
        review.setDescription(reviewbody.getDescription());
        review.setRating(reviewbody.getRating());
        return reviewRepository.save(review);
    }


    public void deleteReview(Long companyId, Long reviewId) {
        Review review = reviewRepository.findByIdAndCompanyId(reviewId,companyId);
        reviewRepository.delete(review);
    }
}
