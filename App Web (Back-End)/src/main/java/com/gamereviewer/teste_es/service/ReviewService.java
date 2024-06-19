package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.repository.GameRepository;
import com.gamereviewer.teste_es.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review criaReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> buscaReviewPorId(String id){
        return reviewRepository.findById(id);
    }

}
