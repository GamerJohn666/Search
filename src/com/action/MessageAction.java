package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.MessageBiz;
import com.biz.UserBiz;
import com.entity.Message;
import com.entity.User;
import com.factory.ObjectFactory;

public class MessageAction
{
    private MessageBiz messageBiz;
    private UserBiz userBiz;
    HttpSession session;
    public MessageAction()
    {
        messageBiz = (MessageBiz)ObjectFactory.getObject("messageBiz");
        userBiz = (UserBiz)ObjectFactory.getObject("userBiz");
    }
    
    //进入我的留言板
    public String goMyMessage(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        User user = (User)session.getAttribute("username");
        
        List<Message> messages = messageBiz.findAllMessage(user.getId());
        List<User> userss = userBiz.showAllUser();
        session.setAttribute("allusers", userss);
        session.setAttribute("mymessage", messages);
        return "success";
    }
    
}
