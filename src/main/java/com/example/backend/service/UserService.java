package com.example.backend.service;

import com.example.backend.dao.UserDao;
import com.example.backend.dto.UserDto;
import com.example.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public User addUser(UserDto userDto){
        User newUser = new User();
        newUser.setUserName(userDto.getUserName());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setId(userDto.getId());
       return userDao.save(newUser);
    }
}
