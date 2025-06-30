package org.example.bms.dto.res;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;
    private String username;
    private String role;

    // 省略 getter 和 setter

    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }
}
