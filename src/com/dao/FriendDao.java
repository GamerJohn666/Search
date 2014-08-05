package com.dao;

import java.util.List;

import com.entity.Friend;


public interface FriendDao
{
    /**
     * 保存好一个好友信息
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public void saveFriend(Friend friend);
    
    /**
     * 根据ID删除一个好友
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public void deleteOneFriend(Integer id);
    
     /**
      * 根据用户的id 更新好友请求状态
      * @param id 根据请求的id
      * @param status 状态
      * @see [类、类#方法、类#成员]
      */
    public void updateFriendByReceiver(Friend friend);
    
    /**
     * 根据用户id 查找自己提出的好友申请
     * @param id 发信人id
     * @return 发送的好友请求
     * @see [类、类#方法、类#成员]
     */
    public List<Friend> findFriendSendId(int sendid);
    
    /**
     * 根据接受者的id 查找自己收到的好友请求
     * @param id 收信人id
     * @return 收到的好友请求
     * @see [类、类#方法、类#成员]
     */
    public List<Friend> findFriendByReceiveId(int receive,int statu);
    
    
    /**
     * 根据id查看好友请求
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Friend findFriendById(int id);
    
    /**
     * 找出自己的好友
     * @param statu
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Friend> findMyFriend(int userid,int statu);
    
    /**
     * 找出交友记录
     * @param statu
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Friend> findMyFriendDetl(int userid,int statu);

    
}
