package com.entity;

import java.io.Serializable;

// 用户实体类
public class User implements Serializable
{
    private int id; // id
    
    private String username;// 用户名
    
    private String password;// 密码
    
    private int sex;// 性别 1：男 0女
    
    private int age;// 年龄
    
    private String nickname;// 昵称
    
    private String hobbies;// 喜欢的爱好
    
    private String pets;// 饲养的宠物
    
    private String registetime;// 注册日期
    
    private int statu;// 状态
    
    private String note;// 备注
    
    public User()
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
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getSex()
    {
        return sex;
    }
    
    public void setSex(int sex)
    {
        this.sex = sex;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    
    public String getHobbies()
    {
        return hobbies;
    }
    
    public void setHobbies(String hobbies)
    {
        this.hobbies = hobbies;
    }
    
    public String getPets()
    {
        return pets;
    }
    
    public void setPets(String pets)
    {
        this.pets = pets;
    }
    
    public String getRegistetime()
    {
        return registetime;
    }
    
    public void setRegistetime(String registetime)
    {
        this.registetime = registetime;
    }
    
    public int getStatu()
    {
        return statu;
    }
    
    public void setStatu(int statu)
    {
        this.statu = statu;
    }
    
    public String getNote()
    {
        return note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }
    
}
