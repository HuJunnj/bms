package org.example.bms.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bms.dto.res.LoginResponse;
import org.example.bms.modle.User;
import org.example.bms.service.LoginService;
import org.example.bms.utils.JwtUtils;
import org.example.bms.utils.Result;
import org.springframework.stereotype.Service;
import org.example.bms.dao.UserMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImp implements LoginService {
    private final UserMapper userMapper;

    public LoginServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public Result<LoginResponse> login(String username, String password) {
        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", password)
        );
        if (user == null) {
            return  Result.error("用户名密码错误");
        }
        String Token = JwtUtils.generateToken(user.getUsername(),user.getRole());
        LoginResponse loginResponse = new LoginResponse(Token,user.getUsername(),user.getRole());
        return  Result.success(loginResponse);
    }
}
