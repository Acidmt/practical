package com.blog.cn.primer.controller;

import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;
import com.blog.cn.primer.service.BlogMessageService;
import com.blog.cn.primer.service.BlogPathService;
import com.blog.cn.register.service.CollectionObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/square")
public class BlogMessageControl {

    @Autowired
    private BlogMessageService blogMessageService;
    @Autowired
    private BlogPathService blogPathService;

    //广场
    @RequestMapping("/")
    public String blogSuccess(Model model){

        List<BlogPathPojo> pathAll =blogPathService.selectAll();
        List<BlogMessagePojo> messageAll=blogMessageService.selectAllMessage();
        Map<BlogPathPojo,BlogMessagePojo> map= CollectionObj.BlogMap(pathAll,messageAll);
        model.addAttribute("BlogPathMessages",map);
        System.out.println(map);
        return "/square";
    }

    //退出
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/square/";
    }

}
