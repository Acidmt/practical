package com.blog.cn.register.service;

import com.blog.cn.register.mapper.RegisterMapper;
import com.blog.cn.register.pojo.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService{
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public int addUser(RegisterUser registerUser) {
        return registerMapper.addUser(registerUser);
    }

    @Override
    public int deleteUserById(int id) {
        return registerMapper.deleteUserById(id);
    }

    @Override
    public List<RegisterUser> selectAll() {
        return registerMapper.selectAll();
    }

    @Override
    public List<RegisterUser> randomSelect(RegisterUser registerUser) {
        return registerMapper.randomSelect(registerUser);
    }

    @Override
    public RegisterUser selectUserById(int id) {
        return registerMapper.selectUserById(id);
    }

}
