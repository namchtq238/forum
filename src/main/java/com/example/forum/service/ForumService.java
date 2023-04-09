package com.example.forum.service;

import com.example.forum.model.User;
import com.example.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ForumService {
    private UserRepository userRepository;

    public User checkUser(String username, String password){
        User user = userRepository.findUserByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
