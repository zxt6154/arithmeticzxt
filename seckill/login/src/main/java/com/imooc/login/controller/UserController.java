package com.imooc.login.controller;

import com.imooc.login.domain.User;
import com.imooc.login.results.Result;
import com.imooc.login.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class UserController {
    @Autowired
    UserServiceImpl userService;


}
