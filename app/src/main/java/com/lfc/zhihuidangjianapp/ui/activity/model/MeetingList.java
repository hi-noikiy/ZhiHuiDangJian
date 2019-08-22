package com.lfc.zhihuidangjianapp.ui.activity.model;

import java.util.List;

/**
 * @date: 2019-08-22
 * @autror: guojian
 * @description:
 */
public class MeetingList extends BasePage {
    List<Meeting> datas;

    public List<Meeting> getDatas() {
        return datas;
    }

    public void setDatas(List<Meeting> datas) {
        this.datas = datas;
    }
}
