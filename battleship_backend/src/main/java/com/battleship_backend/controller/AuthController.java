package com.battleship_backend.controller;

import java.util.List;

import com.battleship_backend.models.Auth;
import com.battleship_backend.models.Login;
import com.battleship_backend.models.User;
import com.battleship_backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService){
        this.authService = authService;
    }

    @GetMapping(value="/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Auth>> getAll(){
        return new ResponseEntity<List<Auth>>(this.authService.getAllAuth(), HttpStatus.OK);
    }

    @PostMapping(value="/check", consumes = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Boolean> checkUsername(@RequestBody String username){
        return new ResponseEntity<Boolean>(this.authService.checkUsernameExists(username), HttpStatus.OK);
    }

    @PostMapping(value="/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUser(@RequestBody Login loginInfo){
        return new ResponseEntity<User>(this.authService.getUser(loginInfo.getUsername(), loginInfo.getPassword()), HttpStatus.OK);
    }

    @PostMapping(value="/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> saveAuth(@RequestBody Auth auth){
        return new ResponseEntity<User>(this.authService.saveAuth(auth),HttpStatus.OK);
    }
}
