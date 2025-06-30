package org.example.bms.controller;

import org.example.bms.dto.req.LoginRequest;
import org.example.bms.dto.res.LoginResponse;
import org.example.bms.modle.User;
import org.example.bms.service.LoginService;
import org.example.bms.service.UserService;
import org.example.bms.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bms/user")
public class Users {
    private final UserService userService;
    public Users(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result<List<User>> users() {
       return userService.getUsers();
    }
}
