package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean validateLogin(User userDTO){
        User user = userRepository.findByEmail(userDTO.getEmail());
        if(user == null){
            return false;
        }
        if (userDTO.getEmail().equals(user.getEmail()) && userDTO.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }

}
