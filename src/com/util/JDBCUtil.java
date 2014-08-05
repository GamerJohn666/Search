package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.*;





public class JDBCUtil
{
    //数据源的方式
    
    //数据源
    private static DataSource ds;
    
    //线程变量    每个线程自己独立的数据
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    
    //静态代码块   在类加载的时候就会被执行
    static
    {
        //初始化数据源
        try
        {
            //加载datasource.properties文件   构建Properties对象
            Properties p = new Properties();//键值对
            p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("datasource.properties"));
            //初始化
            ds = BasicDataSourceFactory.createDataSource(p);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //获得连接对象
    public static Connection getConn()
    {
        //获得与当前线程相关联的连接对象
        Connection conn = threadLocal.get();
        try
        {
            if(null == conn)
            {
                conn = ds.getConnection();//向数据源要一个连接对象
                threadLocal.set(conn);//并与当前线程关联
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    
    //释放资源
    public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs)
    {
        if(null != rs)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(null != pstmt)
        {
            try
            {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(null != conn)
        {
            try
            {
                conn.close();
                threadLocal.remove();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    //移除线程变量中的连接对象
    public static void close()
    {
        Connection conn = threadLocal.get();
        try
        {
            if(null != conn)
            {
               conn.close();
               threadLocal.remove(); 
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
