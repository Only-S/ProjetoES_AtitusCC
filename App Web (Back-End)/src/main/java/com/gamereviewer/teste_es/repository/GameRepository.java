package com.gamereviewer.teste_es.repository;

import com.gamereviewer.teste_es.model.Game;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GameRepository extends MongoRepository<Game, ObjectId> {
    Optional<Game> findByNome(String nome);

    Optional<Game> findById(ObjectId id);
}
