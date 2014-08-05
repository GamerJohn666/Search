package com.biz;

import java.util.List;

import com.entity.Message;

public interface MessageBiz
{
    /**
     * 保存留言信息
     * @param message
     * @see [类、类#方法、类#成员]
     */
    public void saveOneMessage(Message message);
    
    /**
     * 根据留言id 删除留言
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public void deleteOneMessage(Integer id);
    
    /**
     * 根据用户id 查找所有用户留言
     * @param userid
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Message> findAllMessage(Integer userid);
    
    /**
     * 根据id查询
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public  Message findMessageById(int id);
    
}
