package com.example.flutter.user.controller;


import com.example.flutter.user.Dto.LoginDto;
import com.example.flutter.user.Dto.UserDto;
import com.example.flutter.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getFollowById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);}

    @PostMapping("/signin")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto){
        UserDto user = this.userService.getUserByEmail(loginDto.getEmail());
        System.out.println(user.password);
        System.out.println(loginDto.getPassword());
        if (Objects.equals(user.password, loginDto.getPassword())) {
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
