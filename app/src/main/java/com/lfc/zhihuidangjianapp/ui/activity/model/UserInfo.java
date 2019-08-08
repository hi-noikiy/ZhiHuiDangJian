package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-08-08
 * @autror: guojian
 * @description:
 */
public class UserInfo {
    private User user;

    public User getUser() {
        if(user==null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
