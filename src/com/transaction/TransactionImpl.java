package com.transaction;

import java.sql.SQLException;

import com.util.JDBCUtil;

public class TransactionImpl implements Transaction
{
    
    public void beginTransaction()
    {
        try
        {
            JDBCUtil.getConn().setAutoCommit(false);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void commit()
    {
        try
        {
            JDBCUtil.getConn().commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtil.close();
        }
    }
    
    public void rollBack()
    {
        try
        {
            JDBCUtil.getConn().rollback();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtil.close();
        }
    }
    
}
