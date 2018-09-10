package com.danny.drools.demos.business.creditlimit;

/**
 * @author Danny
 * @Title: CreditLimitBusiness
 * @Description:
 * @Created on 2018-09-06 17:41:24
 */
public class CreditLimitBusiness {

    public static void main(String[] args) {
        User user = getUser("Danny", 0, 412, 32000, 25000);
        credit(user);
        System.out.println(user.getUserName() + "最终授信额度为：" + user.getCreditAmount());
    }

    private static void credit(User user) {
        if (user.getMobileOnLineDay() < 365) {
            user.setCreditAmount(0);
        } else {
            user.setCreditAmount(1000);
            if (user.getMonthIncome() > 0 && user.getMonthIncome() <= 10000) {
                user.addCreditAmount(1000);
            } else if (user.getMonthIncome() > 10000 && user.getMonthIncome() <= 20000) {
                user.addCreditAmount(2000);
            } else if (user.getMonthIncome() > 20000) {
                user.addCreditAmount(3000);
            }

            if (user.getSocialBasicAmount() > 0 && user.getSocialBasicAmount() <= 10000) {
                user.addCreditAmount(1000);
            } else if (user.getSocialBasicAmount() > 10000 && user.getSocialBasicAmount() <= 20000) {
                user.addCreditAmount(2000);
            } else if (user.getSocialBasicAmount() > 20000) {
                user.addCreditAmount(3000);
            }
        }
    }

    /**
     * 初始化User实例
     *
     * @param userName
     * @param creditAmount
     * @param mobileOnLineDay
     * @param monthIncome
     * @param socialBasicAmount
     * @return
     */
    private static User getUser(String userName, double creditAmount, int mobileOnLineDay, double monthIncome, double socialBasicAmount) {
        return new User(userName, creditAmount, mobileOnLineDay, monthIncome, socialBasicAmount);
    }
}
