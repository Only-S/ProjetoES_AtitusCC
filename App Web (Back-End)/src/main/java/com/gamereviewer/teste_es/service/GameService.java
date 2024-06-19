package com.gamereviewer.teste_es.service;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class GameService {

    @Autowired
    public GameRepository gameRepository;

    public Optional<Game> buscarJogo(Object id) {
        return gameRepository.buscaPorId(id);
    }
}