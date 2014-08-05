package com.entity;

import java.io.Serializable;

// 留言类
public class Message implements Serializable
{
    private int id;// id
    
    private int sendId;// 发送人id
    
    private int receiveId;// 接收人id
    
    private String note;// 留言内容
    
    private String time;// 时间
    
    private int statu;// 状态
    
    public Message()
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
    
    public int getSendId()
    {
        return sendId;
    }
    
    public void setSendId(int sendId)
    {
        this.sendId = sendId;
    }
    
    public int getReceiveId()
    {
        return receiveId;
    }
    
    public void setReceiveId(int receiveId)
    {
        this.receiveId = receiveId;
    }
    
    public String getNote()
    {
        return note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
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
    
}
