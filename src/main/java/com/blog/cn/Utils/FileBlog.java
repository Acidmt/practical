package com.blog.cn.Utils;


import com.blog.cn.primer.pojo.BlogPathPojo;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileBlog {
    private MultipartFile blog;
    private String registerUsername;
    private HttpSession session;

    public FileBlog(MultipartFile blog, String registerUsername, HttpSession session) {
        this.blog = blog;
        this.registerUsername = registerUsername;
        this.session = session;
    }
    public FileBlog(){

    }

    public String[] renewFileName(BlogPathPojo md5s)throws IOException {
        //获取上传的文件的文件名
        String fileName = blog.getOriginalFilename();
        String fileUserName=registerUsername;
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中blog目录的路径
        ServletContext servletContext = session.getServletContext();
        String blogPath = servletContext.getRealPath("blog/"+fileUserName);
        File file = new File(blogPath);
        //判断路径是否存在
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = blogPath + File.separator + fileName;
        String md5=DigestUtils.md5DigestAsHex(blog.getInputStream());
        if (md5s==null){
            //实现上传功能
            blog.transferTo(new File(finalPath));
            String webBlogPath='/'+registerUsername+'/'+fileName;
            String[] blogUp={md5,webBlogPath};
            return blogUp;
        }else {
            return null;
        }

    }

    public boolean deleteBlog(String fileName,HttpSession session){
        ServletContext servletContext = session.getServletContext();
        String blogPath = servletContext.getRealPath("blog");
        String finalPath = blogPath + File.separator + fileName;
        File file=new File(finalPath);
        return file.delete();
    }


}
