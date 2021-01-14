package com.battleship_backend.controller;

import java.util.List;

import com.battleship_backend.models.Game;
import com.battleship_backend.service.GameService;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/game")
public class GameController {
    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Game>> getAllSavedGames(){
        return new ResponseEntity<List<Game>>(this.gameService.findAll(),HttpStatus.OK);
    }
    
    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> save(@RequestBody Game game){
        return new ResponseEntity<Boolean>(this.gameService.save(game), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Game> getById(@PathVariable int id){
        return new ResponseEntity<Game>(this.gameService.findById(id),HttpStatus.OK);
    }
    
    @GetMapping(value = "/{userId}/{saveName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getByUserIDAndSaveName(@PathVariable String userId, @PathVariable String saveName){
        return new ResponseEntity<String>(this.gameService.findByUserIdAndSaveName(Integer.valueOf(userId), saveName),HttpStatus.OK);
    }
}
