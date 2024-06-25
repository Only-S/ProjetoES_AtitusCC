package com.gamereviewer.teste_es.mapper;

import com.gamereviewer.teste_es.dto.GameDTO;
import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.util.ObjectIdUtil;

import java.util.List;

public class GameMapper {

    public static GameDTO gameToGameDTO(Game game, List<Review> reviews) {
        int quantidadeReviews = game.getListaReviews().size();
        double mediaNotas = GameMapperHelper.calculateMediaNotas(reviews);
        return new GameDTO(
                ObjectIdUtil.objectIdToString(game.getId()),
                game.getNome(),
                game.getCapaPath(),
                game.getExecutavel(),
                game.getCategorias(),
                game.getDescricao(),
                quantidadeReviews,
                mediaNotas
        );
    }
}