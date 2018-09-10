package com.danny.drools.demos.business.point;

import com.danny.drools.model.point.PointDomain;

/**
 * @author Danny
 * @Title: PointBusiness
 * @Description:
 * @Created on 2018-09-05 18:06:09
 */
public class PointBusiness {

    public static void main(String[] args) {
        // 用户Danny初始积分为100，当日购物次数为5次，购物金额为558元，退货次数为0，退货金额为0
        PointDomain pointDomain1 = initPointDomain("Danny", 100, 5, 588, 0, 0);
        // 用户Jackson初始积分为100，当日购物次数为12次，购物金额为1288元，退货次数为2，退货金额为128
        PointDomain pointDomain2 = initPointDomain("Jackson", 100, 12, 1288, 2, 128);
        // 用户Lucy初始积分为100，当日购物次数为0次，购物金额为0元，退货次数为3，退货金额为239
        PointDomain pointDomain3 = initPointDomain("Lucy", 100, 0, 0, 3, 239);

        // 为Danny、Jackson、Lucy三个用户计算积分
        calcPoints(pointDomain1, pointDomain2, pointDomain3);

        // 输出结果
        System.out.println(pointDomain1.getUserName() + "最终积分为：" + pointDomain1.getPoint());
        System.out.println(pointDomain2.getUserName() + "最终积分为：" + pointDomain2.getPoint());
        System.out.println(pointDomain3.getUserName() + "最终积分为：" + pointDomain3.getPoint());
    }

    /**
     * 计算积分
     *
     * @param pointDomains
     */
    private static void calcPoints(PointDomain... pointDomains) {
        long startTime = System.currentTimeMillis();
        for (PointDomain pointDomain : pointDomains) {
            // 当日购物次数
            if (pointDomain.getBuyNums() <= 0) {  //购物次数为0，增加0积分
                pointDomain.addPoint(0);
            } else if (pointDomain.getBuyNums() <= 5) {  //购物次数为1~5，增加1积分
                pointDomain.addPoint(1);
            } else if (pointDomain.getBuyNums() <= 10) {  //购物次数为5~10，增加3积分
                pointDomain.addPoint(3);
            } else {  //购物次数大于10，增加5积分
                pointDomain.addPoint(5);
            }

            // 当日购物总金额
            if (pointDomain.getBuyMoney() <= 0) {  //购物金额为0，增加0积分
                pointDomain.addPoint(0);
            } else if (pointDomain.getBuyMoney() <= 100) {  //购物金额为0~100，增加1积分
                pointDomain.addPoint(1);
            } else if (pointDomain.getBuyMoney() <= 500) {  //购物金额为100~500，增加3积分
                pointDomain.addPoint(3);
            } else {  //购物金额大于500，增加5积分
                pointDomain.addPoint(5);
            }

            // 当日退货总次数
            if (pointDomain.getBackNums() <= 0) {  //退货次数为0，扣除0积分
                pointDomain.subtractPoint(0);
            } else if (pointDomain.getBackNums() <= 5) {  //退货次数为1~5，扣除1积分
                pointDomain.subtractPoint(1);
            } else if (pointDomain.getBackNums() <= 10) {  //退货次数为5~10，扣除3积分
                pointDomain.subtractPoint(3);
            } else {  //退货次数大于10，扣除5积分
                pointDomain.subtractPoint(5);
            }

            // 当日退货总金额
            if (pointDomain.getBackMoney() <= 0) {  //退货金额为0，扣除0积分
                pointDomain.subtractPoint(0);
            } else if (pointDomain.getBackMoney() <= 100) {  //退货金额为0~100，扣除1积分
                pointDomain.subtractPoint(1);
            } else if (pointDomain.getBackMoney() <= 500) {  //退货金额为100~500，扣除3积分
                pointDomain.subtractPoint(3);
            } else {  //退货金额大于500，扣除5积分
                pointDomain.subtractPoint(5);
            }
        }
        System.out.println("规则计算结束，耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * 初始化PointDomain实例
     *
     * @param userName
     * @param point
     * @param buyNums
     * @param buyMoney
     * @param backNums
     * @param backMoney
     * @return
     */
    private static PointDomain initPointDomain(String userName, int point, int buyNums, double buyMoney, int backNums, double backMoney) {
        return new PointDomain(userName, point, buyNums, buyMoney, backNums, backMoney);
    }

}
