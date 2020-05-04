package com.entity;

import com.entity.T_user;

import java.util.List;

public class Page {
    //当前页
    private int currentPage;
    //页面大小
    private int pageSize;
    //当前页的数据集合
    private List<T_user> users;
    //留言信息类
    public List<T_message> messageList;
    //公告信息类
    public List<T_notice> notices;
    //总数据
    public int totalCount;
    //总页数
    private int totalPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }
/*
页面大小
当我们调用了 数据总数大的set()方法和页面大小的set()以后，自动计算出总页数
 */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //自动计算总页数
        this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:(totalCount/pageSize)+1;
    }

    public List<T_user> getUsers() {
        return users;
    }

    public void setUsers(List<T_user> users) {
        this.users = users;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }
    //给总页数赋值：
//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }


    public Page(int currentPage, int pageSize, List<T_user> users, List<T_message> messageList, List<T_notice> notices, int totalCount, int totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.users = users;
        this.messageList = messageList;
        this.notices = notices;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<T_notice> getNotices() {
        return notices;
    }

    public void setNotices(List<T_notice> notices) {
        this.notices = notices;
    }

    public List<T_message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<T_message> messageList) {
        this.messageList = messageList;
    }

    public Page() {
    }
}
