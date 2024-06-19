package com.gamereviewer.teste_es.controller;

import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> criaReview(@RequestBody Review review, @RequestParam ObjectId idGame) {
        Review createdReview = reviewService.criaReview(review, idGame);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping
    public ResponseEntity<Optional<Review>> buscaReviewPorId(@RequestBody String reviewId) {
        Optional<Review> reviewBuscada = reviewService.buscaReviewPorId(reviewId);
        return ResponseEntity.ok(reviewBuscada);
    }

}
