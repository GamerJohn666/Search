package com.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

import com.config.ActionConfig;
import com.config.ForwardConfig;
import com.config.ModuleConfig;

public class ActionServlet extends HttpServlet
{

    private ModuleConfig moduleConfig;
    
    private Map<String,Object> actions = new HashMap<String,Object>();
    
    @Override
    public void init()
        throws ServletException
    {
        Digester digester = DigesterLoader.createDigester(ActionServlet.class.getClassLoader().getResource("rule.xml"));
        moduleConfig = new ModuleConfig();
        digester.push(moduleConfig);
        try
        {
            digester.parse(ActionServlet.class.getClassLoader().getResourceAsStream("mvc.xml"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String path = request.getServletPath();
        path = path.substring(0, path.length() - 3);
        ActionConfig actionConfig = moduleConfig.findActionConfig(path);
        Object action = actions.get(path);
        try{
            if(null == action)
            {
                String type = actionConfig.getType();
                action = Class.forName(type).newInstance();
                actions.put(path, action);
            }
            String methodName = actionConfig.getMethod();
            Method method = action.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            Object name = method.invoke(action, request,response);
            if(!name.toString().equals("ajax"))//处理ajax请求
            {
                ForwardConfig forward = actionConfig.findForwardConfig(name.toString());
                System.out.println("x");
                if(forward.isRedirect())
                {
                    System.out.println("1");
                    response.sendRedirect(request.getContextPath()+forward.getPath());
                }
                else
                { 
                    request.getRequestDispatcher(forward.getPath()).forward(request, response);
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
  
}
