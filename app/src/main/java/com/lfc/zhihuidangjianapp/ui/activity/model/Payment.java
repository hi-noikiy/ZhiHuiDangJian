package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2019-09-03
 * @autror: guojian
 * @description:
 */
public class Payment {

    private String deptName;
    private String money;
    private int paidCount;
    private int personTotalCount;
    private int unPaidCount;
    private String yearMonth;

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setPaidCount(int paidCount) {
        this.paidCount = paidCount;
    }

    public int getPaidCount() {
        return paidCount;
    }

    public void setPersonTotalCount(int personTotalCount) {
        this.personTotalCount = personTotalCount;
    }

    public int getPersonTotalCount() {
        return personTotalCount;
    }

    public void setUnPaidCount(int unPaidCount) {
        this.unPaidCount = unPaidCount;
    }

    public int getUnPaidCount() {
        return unPaidCount;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getYearMonth() {
        return yearMonth;
    }

}
