package com.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//对应mvc.xml中的action-mappings标签
public class ModuleConfig implements Serializable
{
    //键：<action>中的path
    private Map<String,ActionConfig> configs = new HashMap<String, ActionConfig>();

    public Map<String, ActionConfig> getConfigs()
    {
        return configs;
    }

    public void setConfigs(Map<String, ActionConfig> configs)
    {
        this.configs = configs;
    }

    public void addActionConfig(ActionConfig action)
    {
        this.configs.put(action.getPath(), action);
    }
    
    public ActionConfig findActionConfig(String path)
    {
        return this.configs.get(path);
    }
}
