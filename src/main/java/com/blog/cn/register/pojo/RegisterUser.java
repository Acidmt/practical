package com.blog.cn.register.pojo;

import com.blog.cn.primer.pojo.BlogPathPojo;

import java.util.List;

public class RegisterUser {
    private int registerId;
    private String registerUsername;
    private String registerPassword;
    private String email;
    private List<BlogPathPojo> blogPathPojo;

    public List<BlogPathPojo> getBlogPathPojo() {
        return blogPathPojo;
    }

    public void setBlogPathPojo(List<BlogPathPojo> blogPathPojo) {
        this.blogPathPojo = blogPathPojo;
    }

    public RegisterUser(String registerUsername, String registerPassword, String email) {
        this.registerUsername = registerUsername;
        this.registerPassword = registerPassword;
        this.email = email;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public String getRegisterUsername() {
        return registerUsername;
    }

    public void setRegisterUsername(String registerUsername) {
        this.registerUsername = registerUsername;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public RegisterUser() {

    }
    @Override
    public String toString() {
        return "RegisterUser{" +
                "registerId=" + registerId +
                ", registerUsername='" + registerUsername + '\'' +
                ", registerPassword='" + registerPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
