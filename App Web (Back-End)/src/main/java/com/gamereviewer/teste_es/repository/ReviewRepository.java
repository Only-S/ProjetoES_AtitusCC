package com.gamereviewer.teste_es.repository;

import com.gamereviewer.teste_es.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String>{

}
