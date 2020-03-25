package com.example.twitterclone.controllers;

import com.example.twitterclone.model.domain.User;
import com.example.twitterclone.model.dto.UserDto;
import com.example.twitterclone.repository.UserRepository;
import com.example.twitterclone.utilities.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public UserDto something(@PathVariable String id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return UserUtility.toUserDtoFromUser(user);
        }
        throw new IllegalArgumentException("No User Exists with id: "+id);
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto){
        return UserUtility.toUserDtoFromUser(userRepository.save(UserUtility.toUserFromUserDto(userDto)));
    }
}
