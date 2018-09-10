package com.danny.drools.demos.drools.point;

import com.danny.drools.model.point.PointDomain;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author Danny
 * @Title: PointBusiness
 * @Description:
 * @Created on 2018-09-05 22:49:55
 */
public class PointBusiness {

    private static KieServices kieServices = KieServices.Factory.get();
    private static KieContainer kieContainer = kieServices.getKieClasspathContainer();
    private static KieSession kieSession = kieContainer.newKieSession("pointKSession");

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
    public static void calcPoints(PointDomain... pointDomains) {
        long startTime = System.currentTimeMillis();
        int result=0;
        for (PointDomain pointDomain : pointDomains) {
            kieSession.insert(pointDomain);
            result+=kieSession.fireAllRules();
        }
        System.out.println("总共执行了"+result+"条规则，耗时：" + (System.currentTimeMillis() - startTime));
        kieSession.dispose();
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
