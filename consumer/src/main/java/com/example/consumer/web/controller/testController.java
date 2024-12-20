package com.example.consumer.web.controller;

import com.publicInterface.dto.User;
import com.publicInterface.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import part1.Server.integration.References;

/**
 * @Author: yty
 * @Description: TODO
 * @DateTime: 2024/11/08 15:53
 **/
@RestController
@RequestMapping("/api/consumer/test")
public class testController {

    Logger log = LoggerFactory.getLogger(testController.class);

    @References(version = "1.2")
    private UserService userService2;

    @References(version = "1.1")
    private UserService userService1;

    @GetMapping(value = "/test1")
    public User page1() {
        User user = userService1.getUserByUserId(1);
        log.info(user.toString());
        return user;
    }

    @GetMapping(value = "/test2")
    public User page2() {
        User user = userService2.getUserByUserId(2);
        log.info(user.toString());
        return user;
    }
}
