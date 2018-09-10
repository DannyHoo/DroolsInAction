package com.danny.drools.spring.service;

import com.danny.drools.model.point.PointDomain;

/**
 * @author Danny
 * @Title: PointServiceImpl
 * @Description:
 * @Created on 2018-09-09 09:41:19
 */
public interface PointService {

    /**
     * 计算积分
     *
     * @param pointDomain
     * @return
     */
    public PointDomain calcPoints(PointDomain pointDomain);
}
