package org.example.bms.controller;

import org.example.bms.dto.req.LoginRequest;
import org.example.bms.dto.res.LoginResponse;
import org.example.bms.service.LoginService;
import org.example.bms.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms/login")
public class Login {
    private final LoginService loginService;

    public Login(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest.getUsername(),loginRequest.getPassword());
    }
}
