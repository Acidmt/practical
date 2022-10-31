package com.blog.cn.primer.service;

import com.blog.cn.primer.mapper.BlogMessageMapper;
import com.blog.cn.primer.pojo.BlogMessagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogMessageImp implements BlogMessageService{

    @Autowired
    private BlogMessageMapper blogMessageMapper;

    @Override
    public int addMessage(BlogMessagePojo blogMessagePojo) {
        return blogMessageMapper.addMessage(blogMessagePojo);
    }

    @Override
    public int deleteMessage(int id) {
        return blogMessageMapper.deleteMessage(id);
    }

    @Override
    public List<BlogMessagePojo> selectAllMessage() {
        return  blogMessageMapper.selectAllMessage();
    }

    @Override
    public List<BlogMessagePojo> updateMessage(BlogMessagePojo messagePojo) {
        return blogMessageMapper.updateMessage(messagePojo);
    }

    @Override
    public List<BlogMessagePojo> selectById(int id) {
        return blogMessageMapper.selectById(id);
    }

    @Override
    public List<BlogMessagePojo> selectByIdEach(Integer[] arrId) {
        return blogMessageMapper.selectByIdEach(arrId);
    }
}
