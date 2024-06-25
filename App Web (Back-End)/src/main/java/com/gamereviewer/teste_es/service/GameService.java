package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.dto.GameDTO;
import com.gamereviewer.teste_es.mapper.GameMapper;
import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.repository.GameRepository;
import com.gamereviewer.teste_es.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Game criaGame(Game game) {
        return gameRepository.save(game);
    }

    public List<GameDTO> getAllGames() {
        return gameRepository.findAll().stream()
                .map(game -> {
                    List<ObjectId> reviewIds = game.getListaReviews();
                    List<Review> reviews = reviewRepository.findAllById(reviewIds);
                    return GameMapper.gameToGameDTO(game, reviews);
                })
                .collect(Collectors.toList());
    }

    public Optional<GameDTO> getGameById(String id) {
        return gameRepository.findById(new ObjectId(id))
                .map(game -> {
                    List<ObjectId> reviewIds = game.getListaReviews();
                    List<Review> reviews = reviewRepository.findAllById(reviewIds);
                    return GameMapper.gameToGameDTO(game, reviews);
                });
    }

    public Optional<GameDTO> getGameByNome(String nome) {
        return gameRepository.findByNome(nome)
                .map(game -> {
                    List<ObjectId> reviewIds = game.getListaReviews();
                    List<Review> reviews = reviewRepository.findAllById(reviewIds);
                    return GameMapper.gameToGameDTO(game, reviews);
                });
    }

    public Game atualizaGame(String id, Game game) {
        Optional<Game> optionalGame = gameRepository.findById(new ObjectId(id));
        if (optionalGame.isPresent()) {
            Game existingGame = optionalGame.get();
            existingGame.setNome(game.getNome());
            existingGame.setCapaPath(game.getCapaPath());
            existingGame.setQrcode(game.getQrcode());
            existingGame.setExecutavel(game.getExecutavel());
            existingGame.setListaReviews(game.getListaReviews());
            existingGame.setCategorias(game.getCategorias());
            existingGame.setDescricao(game.getDescricao());
            return gameRepository.save(existingGame);
        } else {
            throw new RuntimeException("Game not found with id: " + id);
        }
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(new ObjectId(id));
    }
}