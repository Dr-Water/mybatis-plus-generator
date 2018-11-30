package com.ratel.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.generator.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ratel
 * @since 2018-11-30
 */
public interface IUserService extends IService<User> {

    public User selectByName(String name);
}
