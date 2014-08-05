package com.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory
{
    private static Map<String,Object> objs = new HashMap<String,Object>();

    static
    {
        // 读user.properties文件
        BufferedReader br = new BufferedReader(new InputStreamReader(ObjectFactory.class.getClassLoader().getResourceAsStream("user.properties")));
        try
        {
            String line = br.readLine();
            while(null != line)
            {
                String[] ss = line.split("=");
                objs.put(ss[0],ss[1]);
                line = br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static Object getObject(String key)
    {
        return objs.get(key);
    }
}
