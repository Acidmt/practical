package com.blog.cn.register.controller;

import com.blog.cn.Utils.GetSessionInto;
import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;
import com.blog.cn.primer.service.BlogMessageService;
import com.blog.cn.primer.service.BlogPathService;
import com.blog.cn.register.pojo.IsLoginUser;
import com.blog.cn.register.pojo.RegisterUser;
import com.blog.cn.register.service.CollectionObj;
import com.blog.cn.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterControl {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private BlogPathService blogPathService;
    @Autowired
    private BlogMessageService blogMessageService;
    //配合转发重定向到success页面
    @RequestMapping(value = "/success")
    public String success(HttpSession session, Model model){
        if (session.getAttribute("loginUser")!=null){
            IsLoginUser reg= (IsLoginUser) session.getAttribute("loginUser");
            List<RegisterUser> registerUsersName=registerService.randomSelect(reg);
            if (registerUsersName!=null){
                List<BlogPathPojo> blogPaths=blogPathService.selectById(registerUsersName.get(0).getRegisterId());
                Integer arr[] = new Integer[blogPaths.size()],i=0;
                for (BlogPathPojo bPojo:blogPaths) {
                    arr[i++]=bPojo.getBlogId();
                }
                if (arr.length!=0){
                    List<BlogMessagePojo> blogMessagePojos= blogMessageService.selectByIdEach(arr);
                    Map<BlogPathPojo,BlogMessagePojo> map= CollectionObj.BlogMap(blogPaths,blogMessagePojos);
                    if (map!=null){
                        model.addAttribute("BlogPathMessage",map);
                    }
                }

            }
            return "/success";
        }
        return "redirect:/";
    }

    //首页判断用户是否已经登录
    @RequestMapping(value = "/")
    public String isUser(HttpSession session){
        if (session.getAttribute("loginUser")!=null){
            return "redirect:/success";
        }
        return "index";
    }

    //没有则注册
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String liginUser(String registerUsername,String registerPassword,
                            String registerPassword2,String email,
                            HttpServletResponse response, HttpSession session){
        if (registerPassword.equals(registerPassword2)){
            RegisterUser registerUser=new RegisterUser(registerUsername,registerPassword,email);
            new GetSessionInto(response,null,session).getSessionInto("loginUser",registerUser);
            //添加到数据库
            registerService.addUser(registerUser);
            return "redirect:/success";
        }
        return "redirect:/";
    }

    //登录判断
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(String registerUsername,String registerPassword,
                           HttpServletResponse response,HttpSession session){
        RegisterUser registerUser=new RegisterUser(registerUsername,registerPassword,null);
        List<RegisterUser> list=registerService.randomSelect(registerUser);
        if (list!=null&&!list.isEmpty()){
            for (RegisterUser r:list) {
                if (r.getRegisterUsername().equals(registerUsername)&&r.getRegisterPassword().equals(registerPassword)){
                    IsLoginUser isLoginUser=new IsLoginUser(r.getRegisterUsername(),r.getRegisterPassword());
                    new GetSessionInto(response,null,session).getSessionInto("loginUser",isLoginUser);
                    return "redirect:/success";
                }
            }
        }
        return "redirect:/";
    }

    //注销用户
    @RequestMapping(value = "/delateUser")
    public String delateUser(){
        return "redirect:/";
    }

    //错误界面
    @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }

}
