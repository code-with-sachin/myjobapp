package com.sachinsk.myjobapp.review.impl;

import com.sachinsk.myjobapp.company.Company;
import com.sachinsk.myjobapp.company.CompanyService;
import com.sachinsk.myjobapp.review.Review;
import com.sachinsk.myjobapp.review.ReviewRepository;
import com.sachinsk.myjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

//    public ReviewServiceImpl(CompanyService companyService) {
//        this.companyService = companyService;
//    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }
}
