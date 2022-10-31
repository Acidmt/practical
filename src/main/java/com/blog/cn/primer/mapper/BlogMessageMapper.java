package com.blog.cn.primer.mapper;

import com.blog.cn.primer.pojo.BlogMessagePojo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMessageMapper {

    //插入博客信息
    int addMessage(BlogMessagePojo blogMessagePojo);

    //删除博客信息
    int deleteMessage(int id);

    //查询所有blog
    List<BlogMessagePojo> selectAllMessage();

    //修改博客信息
    List<BlogMessagePojo> updateMessage(BlogMessagePojo messagePojo);

    //根据id查询博客信息
    List<BlogMessagePojo> selectById(int id);

    //根据id批量查询
    List<BlogMessagePojo> selectByIdEach(Integer[] arrId);
}
