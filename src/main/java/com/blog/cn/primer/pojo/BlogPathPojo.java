package com.blog.cn.primer.pojo;

public class BlogPathPojo {
    private int blogId;
    private int blogPathId;
    private String blogPathPath;
    private String blogMd5;

    public BlogPathPojo(int blogPathId, String blogPathPath,  String blogMd5) {
        this.blogPathId = blogPathId;
        this.blogPathPath = blogPathPath;
        this.blogMd5 = blogMd5;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
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

    @Override
    public String toString() {
        return "BlogPathPojo{" +
                "blogId=" + blogId +
                ", blogPathId=" + blogPathId +
                ", blogPathPath='" + blogPathPath + '\'' +
                ", blogMd5='" + blogMd5 + '\'' +
                '}';
    }


}
