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
        try {
            Review createdReview = reviewService.criaReview(review, idGame);
            return ResponseEntity.ok(createdReview);
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error creating review: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> buscaReviewPorId(@PathVariable String id) {
        Optional<Review> reviewBuscada = reviewService.buscaReviewPorId(id);
        if (reviewBuscada.isPresent()) {
            return ResponseEntity.ok(reviewBuscada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
