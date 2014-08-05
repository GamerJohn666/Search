package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.PhotoBiz;
import com.entity.Photo;
import com.entity.User;
import com.factory.ObjectFactory;

public class PhotoAction
{
    private PhotoBiz photoBiz;
    private HttpSession session;
    public PhotoAction()
    {
        photoBiz = (PhotoBiz)ObjectFactory.getObject("photoBiz");
    }

    //进入上传图片
    public String goUploadPhoto(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        
        return "success";
    }
    
    
    //上传图片
    public String upPhoto(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        session = request.getSession(true);
        String username = request.getParameter("username");
        String photoname = request.getParameter("photoname");
        String info = request.getParameter("info");
        String fileName = request.getParameter("fileName");
        
        String path = request.getContextPath()+"/upload/"+username+"/"+fileName;
        Photo photo = new Photo();
        photo.setPath(path);
        photo.setPhoname(photoname);
        photo.setUserid(Integer.parseInt(username));
        photo.setInfo(info);
        photoBiz.savePhoto(photo);
        return "success";
    }
    
    //进入我的宠物相册
    public String goMyphoto(HttpServletRequest request, HttpServletResponse response)
    throws Exception
{
    session = request.getSession(true);
    User user = (User)session.getAttribute("username");
    List<Photo> photos = photoBiz.findAllPhotos(Integer.parseInt(user.getUsername()));
    session.setAttribute("myphotos", photos);
    return "success";
}
}
