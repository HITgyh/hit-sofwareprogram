package com.example.hitsoftware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hitsoftware.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
