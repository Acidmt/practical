package com.blog.cn.primer.service;

import com.blog.cn.primer.mapper.BlogMessageMapper;
import com.blog.cn.primer.mapper.BlogPathMapper;
import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogPathServiceImp implements BlogPathService{
    @Autowired
    private BlogPathMapper blogPathMapper;
    @Autowired
    private BlogMessageMapper blogMessageMapper;

    @Override
    public int addBlog(BlogPathPojo blogPathPojo, BlogMessagePojo blogMessagePojo, List<BlogPathPojo> path) {
        if (path.isEmpty()){
            blogMessageMapper.addMessage(blogMessagePojo);
            return blogPathMapper.addBlog(blogPathPojo);
        }
        return 0;
    }

    @Override
    public int deleteBlog(int id) {
        return blogPathMapper.deleteBlog(id);
    }

    @Override
    public List<BlogPathPojo> selectById(int id) {
        return blogPathMapper.selectById(id);
    }

    @Override
    public List<BlogPathPojo> selectAll() {
        return blogPathMapper.selectAll();
    }

    @Override
    public List<BlogPathPojo> randomBlogSelect(BlogPathPojo blogPathPojo) {
        return blogPathMapper.randomBlogSelect(blogPathPojo);
    }

    @Override
    public List<BlogPathPojo> randomBlogSelectStruct(BlogPathPojo blogPathPojo) {
        return blogPathMapper.randomBlogSelectStruct(blogPathPojo);
    }

    @Override
    public List<BlogPathPojo> selectByIdOne(int id) {
        return blogPathMapper.selectByIdOne(id);
    }
}
