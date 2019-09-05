package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-09-05
 * @autror: guojian
 * @description:
 */
public class Friend {
    private boolean isSelect;
    private User user;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Friend(boolean isSelect, User user) {
        this.isSelect = isSelect;
        this.user = user;
    }
}
