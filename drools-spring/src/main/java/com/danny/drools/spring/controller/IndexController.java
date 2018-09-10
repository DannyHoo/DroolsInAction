package com.danny.drools.spring.controller;

import com.danny.drools.model.point.PointDomain;
import com.danny.drools.spring.service.PointService;
import com.danny.drools.spring.service.impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny
 * @Title: IndexController
 * @Description:
 * @Created on 2018-09-07 16:46:37
 */

@Controller
public class IndexController {

    @Autowired
    private PointService pointService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/calc")
    @ResponseBody
    public Map<String, Object> getGoodsInfo(HttpServletRequest request, PointDomain pointDomain) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询秒杀商品信息（缓存）
        pointDomain = pointService.calcPoints(pointDomain);
        map.put("code", 100000);
        map.put("data", pointDomain);
        map.put("message", "成功");
        return map;
    }
}
