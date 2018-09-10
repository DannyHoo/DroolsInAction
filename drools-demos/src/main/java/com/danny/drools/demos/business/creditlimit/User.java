package com.danny.drools.demos.business.creditlimit;

/**
 * @author Danny
 * @Title: User
 * @Description: 用户
 * @Created on 2018-09-06 14:50:24
 */
public class User {

    // 用户名
    private String userName;
    // 信用额度
    private double creditAmount;
    // 手机号在网时长
    private int mobileOnLineDay;
    // 月收入
    private double monthIncome;
    // 社保缴纳基数
    private double socialBasicAmount;

    public User(String userName, double creditAmount, int mobileOnLineDay, double monthIncome, double socialBasicAmount) {
        this.userName = userName;
        this.creditAmount = creditAmount;
        this.mobileOnLineDay = mobileOnLineDay;
        this.monthIncome = monthIncome;
        this.socialBasicAmount = socialBasicAmount;
    }

    public double addCreditAmount(double addCreditAmount){
        this.creditAmount+=addCreditAmount;
        return this.creditAmount;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public User setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
        return this;
    }

    public int getMobileOnLineDay() {
        return mobileOnLineDay;
    }

    public User setMobileOnLineDay(int mobileOnLineDay) {
        this.mobileOnLineDay = mobileOnLineDay;
        return this;
    }

    public double getMonthIncome() {
        return monthIncome;
    }

    public User setMonthIncome(double monthIncome) {
        this.monthIncome = monthIncome;
        return this;
    }

    public double getSocialBasicAmount() {
        return socialBasicAmount;
    }

    public User setSocialBasicAmount(double socialBasicAmount) {
        this.socialBasicAmount = socialBasicAmount;
        return this;
    }
}
