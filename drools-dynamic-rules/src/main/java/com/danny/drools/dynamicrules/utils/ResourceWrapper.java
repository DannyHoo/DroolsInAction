package com.danny.drools.dynamicrules.utils;

import org.kie.api.io.Resource;
/**
 * @author Danny
 * @Title: ResourceWrapper
 * @Description: 资源包装类
 * @Created on 2018-09-09 10:49:47
 */
public class ResourceWrapper {
    private Resource resource;

    private String   targetResourceName;

    public ResourceWrapper(Resource resource, String targetResourceName) {
        this.resource = resource;
        this.targetResourceName = targetResourceName;
    }

    public Resource getResource() {
        return resource;
    }

    public String getTargetResourceName() {
        return targetResourceName;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setTargetResourceName(String targetResourceName) {
        this.targetResourceName = targetResourceName;
    }

}
