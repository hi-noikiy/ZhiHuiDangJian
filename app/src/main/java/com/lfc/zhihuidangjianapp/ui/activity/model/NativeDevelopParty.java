package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:
 */
public class NativeDevelopParty {
    //0选择时间 1输入内容
    private int styleId;
    private String title;
    private String content;
    public int status;

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NativeDevelopParty(int styleId, String title, String content) {
        this.styleId = styleId;
        this.title = title;
        this.content = content;
    }
}
