package org.example.bms.dto.req;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;

    // 省略 getter 和 setter
}