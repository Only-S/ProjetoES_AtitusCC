package com.gamereviewer.teste_es.controller;

import com.gamereviewer.teste_es.model.Game;
import com.gamereviewer.teste_es.model.Review;
import com.gamereviewer.teste_es.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Optional<Game>> buscarJogo(@RequestBody Object id){
        Optional<Game> gameBuscado = gameService.buscarJogo(id);
        return ResponseEntity.ok(gameBuscado);
    }
}
