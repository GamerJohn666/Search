package com.entity;

import java.io.Serializable;

// 照片类
public class Photo implements Serializable
{
    private int id; // id
    
    private int userid;// 用户的id
    
    private String phoname;// 照片名字
    
    private String path;// 上传路径
    
    private String time;// 上传时间
    
    private int statu;// 照片状态
    
    private String info;//描述
    
    public Photo()
    {
        super();
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getPhoname()
    {
        return phoname;
    }
    
    public void setPhoname(String phoname)
    {
        this.phoname = phoname;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public int getStatu()
    {
        return statu;
    }
    
    public void setStatu(int statu)
    {
        this.statu = statu;
    }
    
    public int getUserid()
    {
        return userid;
    }
    
    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

  
    
    
}
