package com.blog.cn.primer.service;

import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;

import java.util.List;


public interface BlogPathService {
    //添加一个博客
    int addBlog(BlogPathPojo blogPathPojo, BlogMessagePojo blogMessagePojo, List<BlogPathPojo> path);

    //删除一个博客
    int deleteBlog(int id);

    //根据Id查询
    List<BlogPathPojo> selectById(int id);

    //查询所有博客
    List<BlogPathPojo> selectAll();

    //任意字段查询
    List<BlogPathPojo> randomBlogSelect(BlogPathPojo blogPathPojo);

    //任意字段严格查询
    List<BlogPathPojo> randomBlogSelectStruct(BlogPathPojo blogPathPojo);

    //根据唯一Id查询
    List<BlogPathPojo> selectByIdOne(int id);

}
