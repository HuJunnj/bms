package org.example.bms.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bms.dao.UserMapper;
import org.example.bms.modle.User;
import org.example.bms.service.UserService;
import org.example.bms.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private final UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public Result<List<User>> getUsers() {
        return Result.success(userMapper.selectList(new QueryWrapper<User>()));
    }
}
