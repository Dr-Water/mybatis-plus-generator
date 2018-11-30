package com.ratel.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.generator.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ratel
 * @since 2018-11-30
 */
public interface UserMapper extends BaseMapper<User> {

    public User selectByName(@Param("name") String name);

}
