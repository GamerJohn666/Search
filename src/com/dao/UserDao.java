package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao
{
    /**
     * 查看用户名是否存在
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> findUserByUserName(String username);
    

    /**
     * 查看昵称是否存在
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> findUserByNickname(String nickname);
    
    /**
     * 保存用户
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public void save(User user);
    
    /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     * @see [类、类#方法、类#成员]
     */
    public  List<User> findUserByUserNameAndPwd(String username,String password);
    
    /**
     * 根据Id查找用户
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> findUserById( int id);
    
    /**
     * 查询所有的用户
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> findAllUser();
    
    
    /**
     * 更新用户的资料
     * @param user
     * @see [类、类#方法、类#成员]
     */
    public void updateUser(User user);
    
}
