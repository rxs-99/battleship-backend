package com.battleship_backend.service;

import java.util.List;

import com.battleship_backend.models.Game;
import com.battleship_backend.models.User;
import com.battleship_backend.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    
    private GameRepository gameRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public boolean save(Game game){
        try{
            if(this.gameRepository.save(game) == null){
                return false;
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Game> findAll(){
        return this.gameRepository.findAll();
    }

    public Game findBySaveName(String saveName){
        try {
            return this.gameRepository.findBySaveName(saveName);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Game findById(int id){
        try{
            return this.gameRepository.findById(id).get();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Game> findByUser(User user){
        try{
            return this.gameRepository.findAllByUser(user);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Game findByUserAndSaveName(User user, String saveName){
        try{
            return this.gameRepository.findByUserAndSaveName(user, saveName);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        
    }

    public String findByUserIdAndSaveName(int userId, String saveName){
        try{
            return (String)this.gameRepository.findByUserIdAndSaveName(userId, saveName).get(0);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
