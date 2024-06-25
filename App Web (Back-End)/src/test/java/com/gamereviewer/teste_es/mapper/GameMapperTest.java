package com.gamereviewer.teste_es.mapper;

import com.gamereviewer.teste_es.model.Review;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapperTest {

    @Test
    public void testCalculateMediaNotas_MultipleReviews() {
        List<Review> reviews = Arrays.asList(
                new Review(new ObjectId(), 8, 7, 9, 6, "Bom jogo", "usuario1"),
                new Review(new ObjectId(), 5, 6, 7, 8, "Jogo mediano", "usuario2"),
                new Review(new ObjectId(), 9, 8, 6, 7, "Ótimo jogo", "usuario3")
        );

        double media = GameMapperHelper.calculateMediaNotas(reviews);

        assertEquals(7.1667, media, 0.0001);
    }

    @Test
    public void testCalculateMediaNotas_EmptyReviews() {
        List<Review> reviews = Collections.emptyList();

        double media = GameMapperHelper.calculateMediaNotas(reviews);

        assertEquals(0.0, media, 0.0001);
    }

    @Test
    public void testCalculateMediaNotas_SingleReview() {
        List<Review> reviews = Collections.singletonList(
                new Review(new ObjectId(), 10, 9, 8, 7, "Excelente jogo", "usuario1")
        );

        double media = GameMapperHelper.calculateMediaNotas(reviews);

        assertEquals(8.5, media, 0.0001);
    }
}
