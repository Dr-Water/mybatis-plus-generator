package com.ratel.generator.service.impl;

import com.ratel.generator.entity.User;
import com.ratel.generator.mapper.UserMapper;
import com.ratel.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ratel
 * @since 2018-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
