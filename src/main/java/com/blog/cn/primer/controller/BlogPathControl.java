package com.blog.cn.primer.controller;

import com.blog.cn.Utils.FileBlog;
import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;
import com.blog.cn.primer.service.BlogMessageService;
import com.blog.cn.primer.service.BlogPathService;
import com.blog.cn.register.pojo.IsLoginUser;
import com.blog.cn.register.pojo.RegisterUser;
import com.blog.cn.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogPathControl {

    @Autowired
    private BlogPathService blogPathService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private BlogMessageService blogMessageService;

    //文件上传到本地
    @RequestMapping(value = "/uploadBlog/{registerUsername}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadBlog(@RequestParam("upload") MultipartFile blog,
                             @PathVariable("registerUsername")String registerUsername,
                             String blogTitle,String blogText,
                             HttpSession session) throws IOException{
        String md5 = DigestUtils.md5DigestAsHex(blog.getInputStream());
        List<RegisterUser> users=registerService.randomSelect(new RegisterUser(registerUsername,null,null));
        BlogPathPojo blogPathPojoMd5=new BlogPathPojo(users.get(0).getRegisterId(),null,md5);
        //判断上传文件md5值是否在数据库中存在
        List<BlogPathPojo> md5s=blogPathService.randomBlogSelectStruct(blogPathPojoMd5);
        if (md5s.isEmpty()){
            String[] blogUp=new FileBlog(blog,registerUsername,session).renewFileName(null);
            RegisterUser registerUser=new RegisterUser(registerUsername,null,null);
            BlogMessagePojo blogMessagePojo=new BlogMessagePojo(blogTitle,blogText,null);
            List<RegisterUser> registerId= registerService.randomSelect(registerUser);
            if (!registerId.isEmpty()&&blogUp!=null){
                for (RegisterUser itemId:registerId) {
                    if (itemId.getRegisterUsername().equals(registerUsername)){
                        BlogPathPojo blogPathPojo=new BlogPathPojo(itemId.getRegisterId(),blogUp[1],blogUp[0]);
                        BlogPathPojo pathPojo=new BlogPathPojo(blogPathPojo.getBlogPathId(),null,blogPathPojo.getBlogMd5());
                        //在service中判断path是否为null，只有满足用户ID中文件md5不存在则添加
                        List<BlogPathPojo> path=blogPathService.randomBlogSelectStruct(pathPojo);
                        blogPathService.addBlog(blogPathPojo,blogMessagePojo,path);
                        return "OK";
                    }
                }
            }
        }
        return "error";
    }

    //退出登录
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/blogUplod")
    public String blogUplod(HttpSession session){
        if (session.getAttribute("loginUser")!=null){
            return "/upload";
        }
        return "redirect:/error";
    }


    //删除blog
    @RequestMapping(value = "/delete/{blogPathId}/{blogMessageId}")
    public String deleteBlog(@PathVariable("blogPathId")int blogPathId,
                             @PathVariable("blogMessageId") int blogMessageId,
                             HttpSession session){
        if (session.getAttribute("loginUser")!=null){
            IsLoginUser reg= (IsLoginUser) session.getAttribute("loginUser");
            List<RegisterUser> registerUsersName=registerService.randomSelect(reg);
            if (registerUsersName!=null){
                List<BlogPathPojo> blogPathPojo= blogPathService.selectById(registerUsersName.get(0).getRegisterId());
                for (BlogPathPojo pojoId:blogPathPojo) {
                    if (pojoId.getBlogId()==blogPathId){
                        List<BlogPathPojo> listBlog=blogPathService.selectByIdOne(blogPathId);
                        String fileName=listBlog.get(0).getBlogPathPath();
                        blogPathService.deleteBlog(blogPathId);
                        blogMessageService.deleteMessage(blogMessageId);
                        new FileBlog().deleteBlog(fileName,session);
                        return "redirect:/";
                    }
                }
            }

        }
        return "redirect:/error";
    }



}
