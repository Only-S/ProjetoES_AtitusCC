package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.repository.GameRepository;
import com.gamereviewer.teste_es.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            game.getListaReviews().add(savedReview.getId());
            gameRepository.save(game);
        } else {
            throw new RuntimeException("Game not found: " + idJogo);
        }

        return savedReview;
    }

    public Optional<Review> buscaReviewPorId(String id) {
        try {
            if (!ObjectId.isValid(id)) {
                return Optional.empty();
            }
            return reviewRepository.findById(new ObjectId(id));
        } catch (Exception e) {
            System.err.println("Error fetching review: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void deleteReview(String id) {
        reviewRepository.deleteById(new ObjectId(id));
    }
}
