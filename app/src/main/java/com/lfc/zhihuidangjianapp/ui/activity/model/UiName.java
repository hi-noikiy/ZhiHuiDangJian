package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-08-08
 * @autror: guojian
 * @description:
 */
public class UiName {

    private String title;

    private String name;

    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UiName(String title, String name) {
        this.title = title;
        this.name = name;
    }
    public UiName() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
