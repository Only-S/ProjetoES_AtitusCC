package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.repository.GameRepository;
import com.gamereviewer.teste_es.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GameRepository gameRepository;

    public Review criaReview(Review review, ObjectId idJogo) {
        Review savedReview = reviewRepository.save(review);

        Optional<Game> gameOptional = gameRepository.findById(idJogo);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.getLista_reviews().add(savedReview.getId());
            gameRepository.save(game);
        } else {
            throw new RuntimeException("Game not found: " + idJogo);
        }

        return savedReview;
    }

    public Optional<Review> buscaReviewPorId(String id){
        return reviewRepository.findById(id);
    }

}
