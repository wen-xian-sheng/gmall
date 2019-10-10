package com.wen.gmall.user.service.impl;

import com.wen.gmall.user.entity.UmsMember;
import com.wen.gmall.user.mapper.UmsMemberMapper;
import com.wen.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
