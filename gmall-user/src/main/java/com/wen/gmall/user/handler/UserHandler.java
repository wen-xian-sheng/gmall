package com.wen.gmall.user.handler;

import com.wen.gmall.user.entity.UmsMember;
import com.wen.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserHandler {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/get/all")
    public List<UmsMember> getAllUmsMember(){

        return userService.getAllUmsMember();
    }
}
