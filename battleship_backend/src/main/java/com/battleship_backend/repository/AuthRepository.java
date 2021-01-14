package com.battleship_backend.repository;

import java.util.List;

import com.battleship_backend.models.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Auth findByUsername(String username);
    Auth findByUsernameAndPassword(String username, String password);
}
