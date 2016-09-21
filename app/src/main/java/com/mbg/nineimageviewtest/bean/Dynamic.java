package com.mbg.nineimageviewtest.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class Dynamic {
    private User user;
    private String content;
    private List<String> photos;

    public void setUser(User user){
        this.user=user;
    }

    public void setContent(String content){
        this.content=content;
    }

    public void setPhotos(List list){
        this.photos=list;
    }

    public User getUser(){
        return user;
    }

    public String getContent(){
        return content;
    }

    public List getPhotos(){
        return photos;
    }
}
