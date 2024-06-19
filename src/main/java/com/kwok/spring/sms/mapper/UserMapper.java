package com.kwok.spring.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kwok.spring.sms.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
