package com.blog.cn.register.pojo;

public class IsLoginUser extends RegisterUser {

    private String registerUsername;
    private String registerPassword;

    public IsLoginUser(String registerUsername, String registerPassword) {
        this.registerUsername = registerUsername;
        this.registerPassword = registerPassword;
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

    @Override
    public String toString() {
        return "IsLoginUser{" +
                "registerUsername='" + registerUsername + '\'' +
                ", registerPassword='" + registerPassword + '\'' +
                '}';
    }


}
