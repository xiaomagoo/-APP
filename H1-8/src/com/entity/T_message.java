package com.entity;

import java.util.Date;

/*
用户留言信息实体类
 */
public class T_message  {
    private int id;   //留言编号
    private int userId;//留言用户编号
    private String title;//留言标题
    private String context;//留言内容
    private Date time;//留言时间
    private String name;//存放别名


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
