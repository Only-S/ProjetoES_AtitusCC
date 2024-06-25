package com.gamereviewer.teste_es.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamereviewer.teste_es.json.ObjectIdDeserializer;
import com.gamereviewer.teste_es.json.ObjectIdSerializer;
import com.gamereviewer.teste_es.model.Review;
import org.bson.types.ObjectId;

import java.util.List;

public class GameMapperHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new com.fasterxml.jackson.databind.module.SimpleModule()
                .addSerializer(ObjectId.class, new ObjectIdSerializer())
                .addDeserializer(ObjectId.class, new ObjectIdDeserializer()));
    }

    public static String objectIdToString(ObjectId objectId) {
        try {
            return objectMapper.writeValueAsString(objectId).replace("\"", "");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing ObjectId to String", e);
        }
    }

    public static ObjectId stringToObjectId(String id) {
        try {
            return objectMapper.readValue("\"" + id + "\"", ObjectId.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing String to ObjectId", e);
        }
    }

    public static double calculateMediaNotas(List<Review> reviews) {
        return reviews.stream()
                .mapToDouble(review -> (review.getNota_grafico() + review.getNota_trilha_sonora() + review.getNota_historia() + review.getNota_gameplay()) / 4.0)
                .average()
                .orElse(0.0);
    }
}