package com.battleship_backend.service;

import java.util.List;

import com.battleship_backend.models.Auth;
import com.battleship_backend.models.User;
import com.battleship_backend.repository.AuthRepository;
import com.battleship_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthService {
    private AuthRepository authRepository;
    private UserRepository userRepository;

    @Autowired
    public void setAuthRepository(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository= userRepository;
    }

    public boolean checkUsernameExists(String username){
        try{
            if(this.authRepository.findByUsername(username) == null) return false;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Auth> getAllAuth(){
        return this.authRepository.findAll();
    }

    public User getUser(String username, String password){
        // Auth auth;
        try{
            // if((auth = this.authRepository.findByUsernameAndPassword(username,password)) == null){
            //     return null;
            // }
            return this.authRepository.findByUsernameAndPassword(username,password).getUser();
        } catch (NullPointerException e){
            System.out.println("Null pointer exception in getUser(String username, String password) - AuthService.java");
            return null;
        }
    }

    public User saveAuth(Auth auth){
        try{
            return this.authRepository.save(auth).getUser();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
