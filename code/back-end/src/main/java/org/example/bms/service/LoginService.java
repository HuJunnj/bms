package org.example.bms.service;

import org.example.bms.dto.res.LoginResponse;
import org.example.bms.utils.Result;

public interface LoginService {
     Result<LoginResponse> login(String username, String password);
}
