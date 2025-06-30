package org.example.bms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.bms.modle.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}