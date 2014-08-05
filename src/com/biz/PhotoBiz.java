package com.biz;

import java.util.List;

import com.entity.Photo;

public interface PhotoBiz
{
    /**
     * 保存图片信息
     * @param photo
     * @see [类、类#方法、类#成员]
     */
    public void savePhoto(Photo photo);
    
    /**
     * 根据图片id删除图片
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public void deleteOnePhoto(Integer id);
   
    /**
     * 根据id批量删除
     * @param ids
     * @see [类、类#方法、类#成员]
     */
    public void deletePhotos(String ids);
    
    /**
     * 根据用户的id查找图片
     * @param userid
     * @return 图片实体
     * @see [类、类#方法、类#成员]
     */
    public List<Photo> findAllPhotos(Integer userid);
    
    /**
     * 根据id查找图片
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Photo findPhotoById(int id);
}
