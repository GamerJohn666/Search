package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.FriendBiz;
import com.biz.MessageBiz;
import com.biz.PhotoBiz;
import com.biz.UserBiz;
import com.entity.Message;
import com.entity.Photo;
import com.entity.User;
import com.factory.ObjectFactory;

public class ZoneAction
{
    private UserBiz userBiz;
    private MessageBiz messageBiz;
    private FriendBiz friendBiz;
    HttpSession session;
    private PhotoBiz photoBiz;
    
    public ZoneAction()
    {
        userBiz = (UserBiz)ObjectFactory.getObject("userBiz");
        messageBiz = (MessageBiz)ObjectFactory.getObject("messageBiz");
        friendBiz = (FriendBiz)ObjectFactory.getObject("friendBiz");
        photoBiz = (PhotoBiz)ObjectFactory.getObject("photoBiz");
    }
    
    //进入空间
    public String goToZone(HttpServletRequest request, HttpServletResponse response)
    {
        session = request.getSession(true);
        int id = Integer.parseInt(request.getParameter("userid"));
        
        User user = userBiz.showUserById(id);
        List<Message> msg =messageBiz.findAllMessage(id);
        List<Photo> photos = photoBiz.findAllPhotos(Integer .parseInt(user.getUsername()));
        List<User> alluser = userBiz.showAllUser();
        session.setAttribute("zoneallusers", alluser);
        session.setAttribute("zoneuser", user);
        session.setAttribute("zonemsg", msg);
        session.setAttribute("zonephoto", photos);
        return "success";
    }
    
    //留言
    public String addMessage(HttpServletRequest request, HttpServletResponse response)
    {
        session = request.getSession(true);
        int sendId = Integer.parseInt(request.getParameter("sendid"));
        int receiveId = Integer.parseInt(request.getParameter("receiveid"));
        String note = request.getParameter("note");
        Message message = new Message();
        message.setSendId(sendId);
        message.setReceiveId(receiveId);
        message.setNote(note);
        message.setStatu(0);
        messageBiz.saveOneMessage(message);
        
        return "success";
    }
    
     //删除留言
    public String deleteMsg(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        messageBiz.deleteOneMessage(id);
        return "success";
    }
    
}
