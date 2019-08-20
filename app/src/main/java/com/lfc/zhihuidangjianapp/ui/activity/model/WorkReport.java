package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-08-18
 * @autror: guojian
 * @description:
 */
public class WorkReport {
    private String author;
    private String content;
    private String createName;
    private String createTime;
    private String releaseDate;
    private String title;
    private String weeklyWorkReportId;
    private int topNum;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeeklyWorkReportId() {
        return weeklyWorkReportId;
    }

    public void setWeeklyWorkReportId(String weeklyWorkReportId) {
        this.weeklyWorkReportId = weeklyWorkReportId;
    }

    public int getTopNum() {
        return topNum;
    }

    public void setTopNum(int topNum) {
        this.topNum = topNum;
    }
}
