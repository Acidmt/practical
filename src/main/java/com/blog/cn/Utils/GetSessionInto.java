package com.blog.cn.Utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetSessionInto {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;

    public GetSessionInto(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        this.response = response;
        this.request = request;
        this.session = session;
    }

    public void getSessions(String sessionName,Object obj){
        session.setAttribute(sessionName,obj);
    }

    public void getSessionInto(String sessionName,Object obj){
        session.setAttribute(sessionName,obj);
        session.setMaxInactiveInterval(7*24*60*60);
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(7*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
