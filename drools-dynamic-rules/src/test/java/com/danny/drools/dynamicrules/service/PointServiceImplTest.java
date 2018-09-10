package com.danny.drools.dynamicrules.service;

import com.danny.drools.model.point.PointDomain;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

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
    public void calcPointsTest() throws IOException {
        PointDomain pointDomain = new PointDomain("Danny", 100, 5, 588, 0, 0);
        pointService.calcPoints(pointDomain);
    }

}
