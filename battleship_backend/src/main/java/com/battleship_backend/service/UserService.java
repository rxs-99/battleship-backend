package com.battleship_backend.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.battleship_backend.models.User;
import com.battleship_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean addUser(User user){
        try{
            this.userRepository.save(user);
        } catch(IllegalArgumentException e){
            System.out.println("Illegal argument exception on addUser(User user) -- userService");
            return false;
        }
        return true;
    }

    public User findById(int id) {
        try{
            return this.userRepository.findById(id).get();
        } catch(NoSuchElementException e) {
            System.out.println("No such element exception in findById(int id) -- userService");
            return null;
        }
    }

    public boolean updateUser(User user){

        try{
            this.userRepository.save(user);
        } catch(IllegalArgumentException e) {
            System.out.println("Illegal argument exception on updateUser(User user) -- userService");
            return false;
        }

        return true;
    }

    public List<User> getAllUsers(){
        try{
            return this.userRepository.findAll();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
