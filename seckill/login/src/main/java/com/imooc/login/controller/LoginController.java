package com.imooc.login.controller;

import com.imooc.login.domain.User;
import com.imooc.login.domain.UserTest;
import com.imooc.login.domain.vo.LoginVo;
import com.imooc.login.redis.RedisService;
import com.imooc.login.redis.UserKey;
import com.imooc.login.results.Result;
import com.imooc.login.service.UserService;
import com.imooc.login.service.serviceImpl.UserServiceImpl;
import com.imooc.login.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = (Logger) LoggerFactory.getLogger(LoginController.class);
    @Autowired
     UserServiceImpl userService;
    @Autowired
     RedisService redisService;

    @RequestMapping("/logining")
    @ResponseBody
    public Result<Boolean> login(HttpServletResponse response,@Valid LoginVo loginVo){//
        log.info(loginVo.toString());
       // userService.login(response,loginVo);
        return Result.success(true);
    }
    @RequestMapping("/test")
    @ResponseBody
    public Result<Boolean> list(){
        boolean set = redisService.set(UserKey.token, "test", "redistest");
        System.out.println(set);
        return Result.success(set);
    }
}
