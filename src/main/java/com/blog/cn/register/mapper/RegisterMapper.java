package com.blog.cn.register.mapper;

import com.blog.cn.register.pojo.RegisterUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMapper {

//    添加用户
    int addUser(RegisterUser registerUser);

//    注销用户
    int deleteUserById(int id);

//   查询所有用户
    List<RegisterUser> selectAll();

    //根据任意字段查询
    List<RegisterUser> randomSelect(RegisterUser registerUser);

    //根据Id查询用户
    RegisterUser selectUserById(int id);
}
