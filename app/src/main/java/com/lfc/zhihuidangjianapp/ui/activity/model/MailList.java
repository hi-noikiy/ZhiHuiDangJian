package com.lfc.zhihuidangjianapp.ui.activity.model;

import java.util.List;

/**
 * @date: 2019-08-07
 * @autror: guojian
 * @description:
 */
public class MailList {
    private List<Dept> deptList;

    public List<Dept> getUserList() {
        return deptList;
    }

    public void setUserList(List<Dept> userList) {
        this.deptList = userList;
    }
}
