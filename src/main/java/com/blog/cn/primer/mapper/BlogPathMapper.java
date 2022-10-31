package com.blog.cn.primer.mapper;

import com.blog.cn.primer.pojo.BlogPathPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogPathMapper {

    //添加一个博客
    int addBlog(BlogPathPojo blogPathPojo);

    //删除一个博客
    int deleteBlog(int id);

    //根据用户Id查询
    List<BlogPathPojo> selectById(int id);
    //根据唯一Id查询
    List<BlogPathPojo> selectByIdOne(int id);
    //查询所有博客
    List<BlogPathPojo> selectAll();

    //任意字段严格查询
    List<BlogPathPojo> randomBlogSelectStruct(BlogPathPojo blogPathPojo);

    //任意字段查询
    List<BlogPathPojo> randomBlogSelect(BlogPathPojo blogPathPojo);

}
