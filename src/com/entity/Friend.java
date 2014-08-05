package com.entity;

import java.io.Serializable;

// 交友類
public class Friend implements Serializable
{
    private int id;// id
    
    private int sendId;// 发送人id
    
    private int receiveId;// 接收人id
    
    private String time;// 发送时间
    
    private String sendNote;// 发送内容
    
    private String receiveNote;// 回复内容
    
    private int statu;// 状态  0请求 1拒绝 2同意
    
    public Friend()
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
    
 
    
    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getSendNote()
    {
        return sendNote;
    }
    
    public void setSendNote(String sendNote)
    {
        this.sendNote = sendNote;
    }
    
    public String getReceiveNote()
    {
        return receiveNote;
    }
    
    public void setReceiveNote(String receiveNote)
    {
        this.receiveNote = receiveNote;
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
