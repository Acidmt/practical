package com.blog.cn.register.pojo;

import java.sql.Timestamp;

public class CollectionPojo {
    private Integer blogId;
    private int blogPathId;
    private String blogPathPath;
    private String blogMd5;
    private int blogIds;
    private String blogTitle;
    private String blogMessage;
    private Timestamp blogData;

    public CollectionPojo() {

    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public int getBlogPathId() {
        return blogPathId;
    }

    public void setBlogPathId(int blogPathId) {
        this.blogPathId = blogPathId;
    }

    public String getBlogPathPath() {
        return blogPathPath;
    }

    public void setBlogPathPath(String blogPathPath) {
        this.blogPathPath = blogPathPath;
    }

    public String getBlogMd5() {
        return blogMd5;
    }

    public void setBlogMd5(String blogMd5) {
        this.blogMd5 = blogMd5;
    }

    public int getBlogMessageId() {
        return blogIds;
    }

    public void setBlogMessageId(int blogMessageId) {
        this.blogIds = blogMessageId;
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

    public Timestamp getBlogData() {
        return blogData;
    }

    public void setBlogData(Timestamp blogData) {
        this.blogData = blogData;
    }

    public CollectionPojo(Integer blogId, int blogPathId, String blogPathPath, String blogMd5, int blogMessageId, String blogTitle, String blogMessage, Timestamp blogData) {
        this.blogId = blogId;
        this.blogPathId = blogPathId;
        this.blogPathPath = blogPathPath;
        this.blogMd5 = blogMd5;
        this.blogIds = blogMessageId;
        this.blogTitle = blogTitle;
        this.blogMessage = blogMessage;
        this.blogData = blogData;
    }

    @Override
    public String toString() {
        return "CollectionPojo{" +
                "blogId=" + blogId +
                ", blogPathId=" + blogPathId +
                ", blogPathPath='" + blogPathPath + '\'' +
                ", blogMd5='" + blogMd5 + '\'' +
                ", blogIds=" + blogIds +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogMessage='" + blogMessage + '\'' +
                ", blogData='" + blogData + '\'' +
                '}';
    }
}
