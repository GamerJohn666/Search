package com.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ActionConfig implements Serializable
{
    private String path;
    private String type;
    private String method;
    
    
    private Map<String,ForwardConfig> forwards = new HashMap<String, ForwardConfig>();

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public Map<String, ForwardConfig> getForwards()
    {
        return forwards;
    }

    public void setForwards(Map<String, ForwardConfig> forwards)
    {
        this.forwards = forwards;
    }

    public void addForwardConfig(ForwardConfig forwardConfig)
    {
        this.forwards.put(forwardConfig.getName(), forwardConfig);
    }
    
    public ForwardConfig findForwardConfig(String name)
    {
        return this.forwards.get(name);
    }
}
