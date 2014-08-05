package com.config;

import java.io.Serializable;

public class ForwardConfig implements Serializable
{
    private String name;
    
    private String path;
    
    private boolean redirect;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public boolean isRedirect()
    {
        return redirect;
    }
    
    public void setRedirect(boolean redirect)
    {
        this.redirect = redirect;
    }
    
}
