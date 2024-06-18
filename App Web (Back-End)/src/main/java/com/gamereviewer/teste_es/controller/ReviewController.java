package com.gamereviewer.teste_es.controller;

import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> criaReview(@RequestBody Review review) {
        Review createdReview = reviewService.criaReview(review);
        return ResponseEntity.ok(createdReview);
    }
}
