package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game criaGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(String id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> getGameByNome(String nome) {
        return gameRepository.findByNome(nome);
    }

    public Game atualizaGame(String id, Game game) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game existingGame = optionalGame.get();
            existingGame.setNome(game.getNome());
            existingGame.setCapa_path(game.getCapa_path());
            existingGame.setQrcode(game.getQrcode());
            existingGame.setExecutavel(game.getExecutavel());
            existingGame.setLista_reviews(game.getLista_reviews());
            existingGame.setCategorias(game.getCategorias());
            existingGame.setDescricao(game.getDescricao());
            return gameRepository.save(existingGame);
        } else {
            throw new RuntimeException("Game not found with id: " + id);
        }
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }
}