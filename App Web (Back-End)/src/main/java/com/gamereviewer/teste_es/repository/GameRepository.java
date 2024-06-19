package com.gamereviewer.teste_es.repository;

import com.gamereviewer.teste_es.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GameRepository  extends MongoRepository<Game, String> {

    Optional<Game> buscaPorNome(String nomeDoJogo);

    Optional<Game> buscaPorId(Object id);
}
