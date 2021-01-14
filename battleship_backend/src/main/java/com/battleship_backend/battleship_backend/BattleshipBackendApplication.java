package com.battleship_backend.battleship_backend;

import java.util.List;

import com.battleship_backend.models.User;
import com.battleship_backend.service.AuthService;
import com.battleship_backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.battleship_backend.models"})
@ComponentScan("com.battleship_backend")
@EnableJpaRepositories(basePackages = {"com.battleship_backend.repository","com.battleship_backend.models"})
public class BattleshipBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleshipBackendApplication.class, args);
	}

}
