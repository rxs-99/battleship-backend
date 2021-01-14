package com.battleship_backend.repository;

import java.util.List;

import com.battleship_backend.models.Game;
import com.battleship_backend.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Integer>{
    public Game findBySaveName(String saveName);
    public List<Game> findAllByUser(User user);
    public Game findByUserAndSaveName(User user, String saveName);

    @Query(value = "SELECT g.json_as_text FROM game g WHERE g.user_id = :userId AND g.save_name = :saveName", nativeQuery = true)
    public List<Object> findByUserIdAndSaveName(@Param("userId") int userId, @Param("saveName") String saveName);
}
