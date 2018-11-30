package com.ratel.generator.service.impl;

import com.ratel.generator.entity.User;
import com.ratel.generator.mapper.UserMapper;
import com.ratel.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ratel
 * @since 2018-11-30
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User selectByName(String name) {

        User user = userMapper.selectByName(name);

        return user;
    }
}
