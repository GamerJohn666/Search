package com.transaction;

public interface Transaction
{
    /** 
     *开启事务
     * @see [类、类#方法、类#成员]
     */
    public void beginTransaction();
    
    /** 
     *提交事务
     * @see [类、类#方法、类#成员]
     */
    public void commit();
    
    /** 
     * 回滚事务
     * @see [类、类#方法、类#成员]
     */
    public void rollBack();
}
