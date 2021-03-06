package com.danny.drools.spring.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @author Danny
 * @Title: BaseServiceSpringTest
 * @Description:
 * @Created on 2018-09-07 18:00:12
 */
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class BaseServiceSpringTest extends AbstractJUnit4SpringContextTests {

}
