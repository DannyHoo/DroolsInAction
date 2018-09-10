package com.danny.drools.spring.service;

import com.danny.drools.model.point.PointDomain;
import com.danny.drools.spring.service.impl.PointServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Danny
 * @Title: PointServiceImplTest
 * @Description:
 * @Created on 2018-09-07 18:01:49
 */
public class PointServiceImplTest extends BaseServiceSpringTest {

    @Autowired
    private PointService pointService;

    @Test
    public void calcPointsTest() {
        PointDomain pointDomain = new PointDomain("Danny", 100, 5, 588, 0, 0);
        pointService.calcPoints(pointDomain);
    }

}
