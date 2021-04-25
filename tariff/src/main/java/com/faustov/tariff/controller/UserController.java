package com.faustov.tariff.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faustov.tariff.dto.UserDto;
import com.faustov.tariff.entity.User;
import com.faustov.tariff.exception.UsernameNotFoundException;
import com.faustov.tariff.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
      this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
      
            String username = userDto.getUsername();
       
            User user = userService.findByUsername(username);
            
            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            if(!userDto.getPassword().equals(user.getPassword())) {
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            userDto.setPassword("-1");
 
            return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
