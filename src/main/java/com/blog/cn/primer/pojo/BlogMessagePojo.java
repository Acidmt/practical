package com.blog.cn.primer.pojo;

import com.blog.cn.register.pojo.CollectionPojo;

public class BlogMessagePojo extends CollectionPojo {
    private Integer blogIds;
    private String blogTitle;
    private String blogMessage;
    private String blogData;

    @Override
    public String toString() {
        return "BlogMessagePojo{" +
                "blogId=" + blogIds +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogMessage='" + blogMessage + '\'' +
                ", blogData=" + blogData +
                '}';
    }

    public Integer getBlogId() {
        return blogIds;
    }

    public void setBlogId(int blogId) {
        this.blogIds = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogMessage() {
        return blogMessage;
    }

    public void setBlogMessage(String blogMessage) {
        this.blogMessage = blogMessage;
    }

    public String getData() {
        return blogData;
    }

    public void setData(String blogData) {
        this.blogData = blogData;
    }

    public BlogMessagePojo(String blogTitle, String blogMessage, String blogData) {
        this.blogTitle = blogTitle;
        this.blogMessage = blogMessage;
        this.blogData = blogData;
    }


}
