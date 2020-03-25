package com.example.twitterclone.utilities;

import com.example.twitterclone.model.domain.User;
import com.example.twitterclone.model.dto.UserDto;

public class UserUtility {
    public static User toUserFromUserDto(UserDto userDto){
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        return user;
    }

    public static UserDto toUserDtoFromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        return userDto;
    }
}
