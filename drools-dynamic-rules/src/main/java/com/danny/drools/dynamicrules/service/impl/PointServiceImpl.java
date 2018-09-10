package com.danny.drools.dynamicrules.service.impl;

import com.danny.drools.dynamicrules.service.PointService;
import com.danny.drools.model.point.PointDomain;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KSession;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author Danny
 * @Title: PointServiceImpl
 * @Description:
 * @Created on 2018-09-07 17:07:31
 */
@Service("pointService")
public class PointServiceImpl extends BaseServiceImpl implements PointService {

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
    public PointDomain calcPoints(PointDomain pointDomain) throws IOException {
        long startTime = System.currentTimeMillis();
        KieHelper helper = new KieHelper();
        helper.addContent(getRulesStr(""), ResourceType.DRL);
        KieSession kieSession=helper.build().newKieSession();
        kieSession.insert(pointDomain);
        int result = kieSession.fireAllRules();
        System.out.println("总共执行了" + result + "条规则，耗时：" + (System.currentTimeMillis() - startTime));
        kieSession.dispose();
        return pointDomain;
    }

    /**
     * 获取规则资源
     * @param ruleName
     * @return
     * @throws IOException
     */
    public  String getRulesStr(String ruleName) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(new File("/Users/dannyhoo/data/rules/txt/pointRule.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
