package com.biz;

import java.util.List;

import com.entity.User;

public interface UserBiz
{
    /**
     * 查看用户名是否存在
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public boolean isUserNameExist(String username);
    

    /**
     * 查看昵称是否存在
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public boolean isNickNameExist(String nickname);
    
    /**
     * 保存用户
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    public void registe(User user);
    
    /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User loginUser(String username,String password);
    
    /**
     * 根据Id查找用户
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User showUserById( int id);
    
    /**
     * 查询所有的用户
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> showAllUser();
    
    
    /**
     * 更新用户的资料
     * @param user
     * @see [类、类#方法、类#成员]
     */
    public void changeUser(User user);
}
