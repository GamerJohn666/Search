package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate
	{
	    // “增删改”操作
	    public void update(String sql, Object... params)
	    {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        try
	        {
	            conn = JDBCUtil.getConn();
	            pstmt = conn.prepareStatement(sql);
	            setParams(pstmt, params);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            JDBCUtil.close(null, pstmt, null);
	        }
	    }
	    
	    // "查询"操作
	    public List query(String sql,ObjectMapper om,Object... params)
	    {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        List list = new ArrayList();
	        try
	        {
	            conn = JDBCUtil.getConn();
	            pstmt = conn.prepareStatement(sql);
	            setParams(pstmt, params);
	            rs = pstmt.executeQuery();
	            if(null != rs)
	            {
	                while(rs.next())
	                {
	                    Object obj = om.mapperObject(rs);
	                    list.add(obj);
	                }
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            JDBCUtil.close(null, pstmt, rs);
	        }
	        return list;
	    }
	    
	    //给占位符赋值
	    private void setParams(PreparedStatement pstmt,Object... params)
	    {
	        if(null != pstmt)
	        {
	            if(null != params && params.length > 0)
	            {
	                for(int i = 0; i < params.length; i++)
	                {
	                    try
	                    {
	                        pstmt.setString(i+1, params[i].toString());
	                    }
	                    catch (SQLException e)
	                    {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}
