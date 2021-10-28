package cdu.mayong.controller;

import cdu.mayong.service.UserService;
import cdu.mayong.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Api(value = "用户后端接口", tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户登录用户名", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "用户登录密码", dataType = "string", required = true)
    })
    @GetMapping("/login/{username}/{password}")
    public ResultVo login(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.checkLogin(username, password);
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", dataType = "string", required = true)
    })
    @PostMapping("/register/{username}/{password}")
    public ResultVo register(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.userRegister(username, password);
    }


}
