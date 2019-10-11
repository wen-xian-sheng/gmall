package com.wen.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wen.gmall.user.bean.UmsMember;
import com.wen.gmall.user.mapper.UmsMemberMapper;
import com.wen.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getAllUmsMember() {
        return umsMemberMapper.selectAll();

        //return umsMemberMapper.selectAllUser();
    }
}
