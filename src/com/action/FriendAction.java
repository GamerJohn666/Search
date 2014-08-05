package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.FriendBiz;
import com.biz.UserBiz;
import com.entity.Friend;
import com.entity.User;
import com.factory.ObjectFactory;

public class FriendAction
{
    private FriendBiz friendBiz;
    
    private UserBiz userBiz;
    
    HttpSession session;
    
    public FriendAction()
    {
        friendBiz = (FriendBiz)ObjectFactory.getObject("friendBiz");
        userBiz = (UserBiz)ObjectFactory.getObject("userBiz");
    }
    
    // 进入我的朋友
    public String goMyFriends(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        User user = (User)session.getAttribute("username");
        List<Friend> friends = friendBiz.findMyFriend(user.getId(), 2);
        List<User> userss = userBiz.showAllUser();// 获得所有的用户
        session.setAttribute("allusers", userss);
        session.setAttribute("myfriends", friends);
        return "success";
    }
    
    // 进入添加好友界面
    public String goAddFriends(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        User user = (User)session.getAttribute("username");
        List<User> userss = userBiz.showAllUser();
        if (userss.size() == 1)// 只有当前用户一人
        {
            session.setAttribute("users", null);
        }
        else
        {
            List<Friend> f1 = friendBiz.findMyFriendDetl(user.getId(), 1);// 找出已经添加位好友的记录
            
            for (int i = 0; i < f1.size(); i++)// 排除好友 找出可以添加的好友
            {
                for (int j = 0; j < userss.size(); j++)
                {
                    if (userss.get(j).getId() == f1.get(i).getReceiveId() || userss.get(j).getId() == f1.get(i).getSendId())
                    {
                        userss.remove(j);// 移除有记录的好友记录
                    }
                    
                }
            }
            
            session.setAttribute("users", userss);
        }
        return "success";
    }
    
    // 添加好友
    public String addFriend(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        int receiveId = Integer.parseInt(request.getParameter("receiveid"));
        String sendnote = request.getParameter("sendnote");
        User user = (User)session.getAttribute("username");
        
        Friend friend = new Friend();// 封装好友
        friend.setReceiveId(receiveId);
        friend.setSendNote(sendnote);
        friend.setSendId(user.getId());
        
        friendBiz.addFriend(friend);
        
        return "success";
    }
    
    // 进入我的好友请求
    public String goMyFriendReq(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        User user = (User)session.getAttribute("username");
        List<Friend> friends = friendBiz.findFriendSendId(user.getId());
        List<User> userss = userBiz.showAllUser();
        session.setAttribute("allusers", userss);
        session.setAttribute("myfriendreq", friends);
        return "success";
    }
    
    // 进入申请我为好友的请求
    public String goMyFriendResp(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        User user = (User)session.getAttribute("username");
        List<Friend> friends = friendBiz.findFriendByReceiveId(user.getId(), 0);
        List<User> userss = userBiz.showAllUser();// 获得所有的用户
        session.setAttribute("allusers", userss);
        session.setAttribute("myfriendresp", friends);
        
        return "success";
    }
    
    // 确认好友关系
    public String confirmFriend(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        int id = Integer.parseInt(request.getParameter("id"));// 记录id
        String receiveNote = request.getParameter("receivenote");
        int msg = Integer.parseInt(request.getParameter("msg"));// 状态
        Friend friend = friendBiz.findFriendById(id);
        friend.setReceiveNote(receiveNote);
        friend.setStatu(msg);
        friendBiz.updateFriendByReceiver(friend);
        return "success";
    }
    
    public String deleteFriend(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        friendBiz.deleteOneFriend(id);
        return "success";
    }
    
}
