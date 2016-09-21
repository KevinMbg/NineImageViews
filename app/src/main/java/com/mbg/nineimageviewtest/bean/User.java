package com.mbg.nineimageviewtest.bean;

/**
 * Created by Administrator on 2016/9/21.
 */
public class User {
    public String headIconUrl;
    public String nickName;
    public int id;

    public User(String url,String nick){
        this(url, nick,0);
    }

    public User(String url,String nick,int id){
        this.id=id;
        this.headIconUrl=url;
        this.nickName=nick;
    }
}