package com.abuzar.jobapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abuzar.jobapp.model.Company;
import com.abuzar.jobapp.model.Job;
import com.abuzar.jobapp.model.Review;
import com.abuzar.jobapp.repository.CompanyRepository;
import com.abuzar.jobapp.repository.ReviewRepository;

@Service
public class ReviewService {
	ReviewRepository reviewRepository;
	private CompanyService companyService; 

	public ReviewService(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}
	
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	public Boolean addReviewById(Review review, Long companyId) {
		Company company = companyService.findCompanyById(companyId);
		if(company != null)
		{
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
		
	}

	public Review getReviewById(Long id, Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getId().equals(id)).
				findFirst().orElse(null);
	}
	
	public Boolean updateReviewById(Review review, Long id, Long companyId) {
		Review r  = getReviewById(id, companyId);
		
		if(r != null)
		{
			r.setTitle(review.getTitle());
			r.setDescription(review.getDescription());
			r.setRating(review.getRating());
			reviewRepository.save(r);
			return true;
		}
		return false;
	}
	
	public Boolean deleteReviewById(Long id, Long companyId) {
		if(companyService.findCompanyById(companyId) != null && reviewRepository.existsById(id)) {
			/*Review review = reviewRepository.findById(id).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			companyService.updateCompany(companyId, company);
			*/
			reviewRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
