package com.danny.drools.spring.service.impl;

import com.danny.drools.model.point.PointDomain;
import com.danny.drools.spring.service.PointService;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @author Danny
 * @Title: PointServiceImpl
 * @Description:
 * @Created on 2018-09-07 17:07:31
 */
@Service("pointService")
public class PointServiceImpl extends BaseServiceImpl implements PointService{

    @KBase("pointKBase")
    private KieBase kieBase;

    @KSession("pointKSession")//必须要加name
    private KieSession kieSession;

    /**
     * 计算积分
     *
     * @param pointDomain
     * @return
     */
    public PointDomain calcPoints(PointDomain pointDomain) {
        long startTime = System.currentTimeMillis();
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(pointDomain);
        int result = kieSession.fireAllRules();
        System.out.println("总共执行了" + result + "条规则，耗时：" + (System.currentTimeMillis() - startTime));
        kieSession.dispose();
        return pointDomain;
    }

}
