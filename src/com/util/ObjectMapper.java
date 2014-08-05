package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface ObjectMapper
{
    /** 
     * 将结果集转成对应的实体对象
     * @param rs  查询的结果集
     * @return  转换后的对象
     * @throws SQLException 
     * @see [类、类#方法、类#成员]
     */
    public Object mapperObject(ResultSet rs) throws SQLException;
}
