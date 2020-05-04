package com.entity;

import java.util.Date;

public class T_notice {
    private int Id;//公告信息编号
    private String Title;//公告标题
    private String Content;//公告内容
    private Date Time;//公告时间

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }
}
