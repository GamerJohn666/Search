package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.entity.BaseEntity;
import com.factory.ObjectFactory;

public class UserAction
{

    
    PrintWriter out = null;
    
    public UserAction()
    {       
        
    }
    
    // 进入登录页面
    public String goLoginPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "success";
    }
    
  
    // 用户登录
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(true);
        BaseEntity baseEntity = new BaseEntity();
        String name = request.getParameter("empUser");
        String password = request.getParameter("empPassword");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try
        {
            out= response.getWriter();
            if(!password.equals(ObjectFactory.getObject(name)))
            {
                baseEntity.setIsSuccessOrfail("Faile");
                baseEntity.setMessage("<font color='red'>&nbsp;&nbsp;*用户名或密码错误!</font>");           
            }        
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(baseEntity.getIsSuccessOrfail());
        JSONObject arr = JSONObject.fromObject(baseEntity);
        out.println(arr);   
        out.flush();
        out.close();
   
        return "ajax";
    }
    
    // 进入主画面
    public String goToMain(HttpServletRequest request, HttpServletResponse response)
    {
         return "success";
    }
    
    // 进入对比画面
    public String goInput(HttpServletRequest request, HttpServletResponse response)
    {
         return "success";
    }
    
    // 进入结果画面
    public String goDetail(HttpServletRequest request, HttpServletResponse response)
    {
         return "success";
    }
    
    //用户注销
    public String logOff(HttpServletRequest request, HttpServletResponse response)
    {
         HttpSession session = request.getSession();
         session.removeAttribute("username");
         return "success";
    }
    
    
}
