package com.ratel.generator.controller;


import com.ratel.generator.entity.User;
import com.ratel.generator.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ratel
 * @since 2018-11-30
 */
@RestController
@RequestMapping("/generator/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public List<User> list() {
        List<User> users = iUserService.list(null);
        return users;
    }


    @GetMapping("/save")
    public String save() {
        User user = new User();
        // user.setId(7);
        user.setAge(18);
        user.setName("马云");
        user.setEmail("杭州师范");
        iUserService.save(user);
        return "success";
    }

}
