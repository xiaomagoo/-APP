package com.service;

import com.dao.UserDao;
import com.entity.T_message;
import com.entity.T_notice;
import com.entity.T_user;
import com.util.DBConnection;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDao sd=new UserDao();
  /*
  用户信息管理模块
   */
  //执行分页查询(用户信息)
  public List<T_user> queryT_usersByPage(int currentPage,int PageSize){
      return sd. queryT_usersByPage(currentPage,PageSize);
  }
    public int insertUser(T_user user){
        return sd.insertUser(user);
    }
    public T_user findByIdFind(int id){
        return sd.findByIdFind(id);
    }
    public int DelById(int[] dels){
        return sd.DelById(dels);
    }
    public int  updateState(int id){
        return sd.updateState(id);
    }
    public int  updateStateAble(int id){
        return sd.updateStateAble(id);
    }
    /*
    用户留言信息管理模块
     */
    //查询用户留言列表
    public List<T_message> queryT_messageByPage(int currentPage, int PageSize){
       return sd.queryT_messageByPage(currentPage,PageSize);
    }
    //查询用户留言的详细信息
    public T_message findById_message(int uid){
        return sd.findById_message(uid);
    }
    //删除用户留言列表中的留言
    public int Del_messageInfo(int[] id){
        return sd.Del_messageInfo(id);
    }
    /*
    公告通知模块
     */
    //执行分页查询(公告信息)
    public List<T_notice> queryT_noticesByPage(int currentPage,int PageSize){
        return sd. queryT_noticesByPage(currentPage,PageSize);
    }
    //查询公告的单个详细信息列表
    public T_notice manageGongGaoById(int uid){
        return sd.manageGongGaoById(uid);
    }
    //根据id信息的去更改相应的公告主体，和公告内容
    public int updatemanageGongGaoById(int id,String title,String content){
        return sd.updatemanageGongGaoById(id,title,content);
    }
    //根据id去添加公告信息
    public int insertNotice(T_notice notice){
        return sd.insertNotice(notice);
    }
    //根据id去进行删除公告操作
    public int GgDelById(int[] id){
       return sd.GgDelById(id);
    }
    /*
    实现数据的分页查询
     */
    //查询总数据数
    public int getTotalCount(String sql){
      return sd.getTotalCount(sql);
    }
}
