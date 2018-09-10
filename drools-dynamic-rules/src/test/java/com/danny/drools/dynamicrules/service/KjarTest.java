package com.danny.drools.dynamicrules.service;

import com.danny.drools.model.point.PointDomain;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;

/**
 * @author Danny
 * @Title: KjarTest
 * @Description:
 * @Created on 2018-09-10 11:26:21
 */
public class KjarTest {

    KieServices kieServices;
    KieContainer kieContainer;
    KieScanner kScanner;

    public KjarTest() {
        kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId("com.danny.drools", "drools-kjar", "1.0-SNAPSHOT");
        kieContainer = kieServices.newKieContainer(releaseId);
        kScanner = kieServices.newKieScanner(kieContainer);
        kScanner.start(10000L);
    }

    public static void main(String[] args) {

    }

}
