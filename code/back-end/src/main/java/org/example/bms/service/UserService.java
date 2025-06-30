package org.example.bms.service;

import org.example.bms.dto.res.LoginResponse;
import org.example.bms.modle.User;
import org.example.bms.utils.Result;

import java.util.List;

public interface UserService {
    Result<List<User>> getUsers();
}
