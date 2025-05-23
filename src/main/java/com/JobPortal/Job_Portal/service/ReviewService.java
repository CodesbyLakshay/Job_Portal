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

    public Review updateReview(Long companyId, Long reviewId, Review newreviewbody) {
        Review review = reviewRepository.findByIdAndCompanyId(reviewId,companyId);
        review.setTitle(newreviewbody.getTitle());
        review.setDescription(newreviewbody.getDescription());
        review.setRating(newreviewbody.getRating());
        return reviewRepository.save(review);
    }

    public void deleteReview(Long companyId, Long reviewId) {
        Review review = reviewRepository.findByIdAndCompanyId(reviewId,companyId);
        reviewRepository.delete(review);
    }

    public List<Company> getCompanyByRating(Long companyId, double rating) {
        List<Company> companyList = companyService.getAllCompanies();
        companyList.remove(rating<3);
        return companyList;
    }
}
