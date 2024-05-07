package com.abuzar.jobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abuzar.jobapp.model.Review;
import com.abuzar.jobapp.service.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
	
	ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
	}
	
	@PostMapping("/") 
	public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long companyId) {
		Boolean isAdded = reviewService.addReviewById(review, companyId);
		if (isAdded) {
			return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
		}
	}
		
	
	@GetMapping("/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long id, @PathVariable Long companyId) {
		Review review = reviewService.getReviewById(id, companyId);
		if(review != null)
		{
			return new ResponseEntity<>(review, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateReviewById(@RequestBody Review review, @PathVariable Long id, @PathVariable Long companyId) { 
		Boolean isUpdated = reviewService.updateReviewById(review, id, companyId);
		if(isUpdated)
		{
			return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to Update", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteReviewById(@PathVariable Long id, @PathVariable Long companyId) {
		Boolean isDeleted = reviewService.deleteReviewById(id, companyId);
		if(isDeleted)
		{
			return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to Delete", HttpStatus.NOT_FOUND);
		}
	}

}

