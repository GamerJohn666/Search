package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
        //HttpSession session = request.getSession(true);
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
        JSONObject arr = JSONObject.fromObject(baseEntity);
        out.println(arr);   
        out.flush();
        out.close();
   
        return "ajax";
    }
    
    // 进入主画面
    public String goToMain(HttpServletRequest request, HttpServletResponse response)
    {

        File file = new File(request.getSession().getServletContext().getRealPath("/Compare/"));
        file.mkdirs();
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
    
    public String getFile(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {

        //String exportFileName = request.getParameter("exportName");
        String exportFileName = new String((request.getParameter("exportName")).getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(exportFileName);
        String importFileName = new String((request.getParameter("exportName")).getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(importFileName);
        //File exportFile = new File(request.getSession().getServletContext().getRealPath("//Compare//"+exportFileName));
     
        //File importFile = new File(request.getSession().getServletContext().getRealPath("//Compare//"+importFileName));
        
        return "ajax";
    }
    
    
    //用户注销
    public String logOff(HttpServletRequest request, HttpServletResponse response)
    {
         HttpSession session = request.getSession();
         session.removeAttribute("username");
         return "success";
    }
    
    
}
