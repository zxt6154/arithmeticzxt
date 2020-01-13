package com.test.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("redis")
@ResponseBody
public class RedisTestController {
    @RequestMapping("test")
    public String test(){
        return "hello,redis";
    }
}
