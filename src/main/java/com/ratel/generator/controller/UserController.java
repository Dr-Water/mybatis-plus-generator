package com.ratel.generator.controller;


import com.ratel.generator.entity.User;
import com.ratel.generator.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    public User selectByName(@PathVariable String name) {
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


    @ApiOperation(value="根据用户名获取用户", notes="根据用户的姓名获取用户")
    @ApiImplicitParam(name = "name", value = "用户名",required = false, dataType = "String" ,paramType="query" )
    @GetMapping("/selectByName3")
    public User selectByName3(@RequestParam String name) {
        User user = iUserService.selectByName(name);
        return user;
    }




    //使用@PathVariable注解进行传递参数，可方法的参数列表中以不用加required = false,  但是 @ApiImplicitParam中paramtype必须是path，否则无法传参
    @ApiOperation(value="根据用户名获取用户", notes="根据用户的姓名获取用户")
    @ApiImplicitParam(name = "name", value = "用户名",required = false, dataType = "String" ,paramType="path" )
    @GetMapping("/selectByName4/{name}")
    public User selectByName4(@PathVariable String name) {
        User user = iUserService.selectByName(name);
        return user;
    }


    //@ApiImplicitParam中的required=true控制的是Swagger页面的参数不能为空，这时点击try it  out是不能发送请求的，使用这个注解必须将paramType这个参数加上去，否则无法拼接参数
    //@RequestParam(required = false)控制的是url里的参数可以为空，如果传参会动态拼接在url的后面
    @ApiOperation(value="根据用户名获取用户", notes="根据用户的姓名获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名",required = false, dataType = "String" ,paramType="query" ),
            @ApiImplicitParam( name = "id", value = "用户id", required = true, dataType = "String",paramType="query" )
    })
    @GetMapping("/selectByName5")
    public User selectByName5(@RequestParam(required = false) String name, @RequestParam(required = false) String id) {
        System.out.println(id);
        User user = iUserService.selectByName(name);
        return user;
    }


}
