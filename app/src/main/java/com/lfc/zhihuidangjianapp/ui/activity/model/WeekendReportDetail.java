package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-08-10
 * @autror: guojian
 * @description:
 */
public class WeekendReportDetail {

    /**
     * 用户code
     */
    private String userNumber;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 发布日期
     */
    private String releaseDate;

    /**
     * 是否置顶(0:是1:否)
     */
    private Integer ifTop;

    /**
     * 置顶序号
     */
    private Integer topNum;

    /**
     * 是否通过(0:是1:否)
     */
    private Integer ifPass;

    /**
     * 参加组织生活情况
     */
    private String comment1;

    /**
     * 参加学习教育情况
     */
    private String comment2;

    /**
     * 承诺践诺完成情况（含党员示范岗、党员责任区的完成情况）
     */
    private String comment3;

    /**
     * 其他需报告党组织事宜
     */
    private String comment4;

    /**
     * 部门
     */
    private String dept;

    /**
     * 部门code
     */
    private String deptCode;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人code
     */
    private String createCode;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 备注
     */
    private String remark;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getIfTop() {
        return ifTop;
    }

    public void setIfTop(Integer ifTop) {
        this.ifTop = ifTop;
    }

    public Integer getTopNum() {
        return topNum;
    }

    public void setTopNum(Integer topNum) {
        this.topNum = topNum;
    }

    public Integer getIfPass() {
        return ifPass;
    }

    public void setIfPass(Integer ifPass) {
        this.ifPass = ifPass;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getComment3() {
        return comment3;
    }

    public void setComment3(String comment3) {
        this.comment3 = comment3;
    }

    public String getComment4() {
        return comment4;
    }

    public void setComment4(String comment4) {
        this.comment4 = comment4;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateCode() {
        return createCode;
    }

    public void setCreateCode(String createCode) {
        this.createCode = createCode;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
