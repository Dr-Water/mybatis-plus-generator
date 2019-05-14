package com.ratel.generator.controller;


import com.ratel.generator.entity.User;
import com.ratel.generator.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value="获取所有用户")
    @GetMapping("/list")
    public List<User> list() {
        List<User> users = iUserService.list(null);
        return users;
    }

    @ApiOperation(value="保存用户")
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

    @ApiOperation(value="根据用户名获取用户", notes="根据用户的姓名获取用户")
    @GetMapping("/selectByName/{name}")
    public User selectByName(@PathVariable(required = false) String name) {
        System.out.println(name);
        User user = iUserService.selectByName(name);
        return user;
    }

    //@ApiOperation(value="根据用户名获取用户", notes="根据用户的姓名获取用户")
    //@ApiImplicitParam(name = "name", value = "用户名")
    @ApiOperation("根据用户名获取用户")
    @GetMapping("/selectByName2")
    public User selectByName2(@RequestParam(required = false) String name) {
        User user = iUserService.selectByName(name);
        return user;
    }


}
