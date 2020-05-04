package com.dao;

import com.entity.T_message;
import com.entity.T_notice;
import com.entity.T_user;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //数据库操作流程
//1、准备好sql语句。
//2、取得数据库连接。
//3、将sql语句用PreparedStatement进行封装。
//4、给sql语句中的问号进行幅值。
//5、执行sql语句封装并获取返回值。
    Connection conn = null;
    PreparedStatement psm = null;
    ResultSet rs = null;
    String sql = null;
    ArrayList<T_user> as = null;
    T_user auat = null;
    T_message t_message=null;
    int flag;
    T_notice notice=null;
    /*
    用户信息管理模块
     */
    //执行分页查询
    public List<T_user> queryT_usersByPage(int currentPage,int PageSize) {
        int[] params={currentPage,(PageSize-1)*currentPage};
        List<T_user> users=new ArrayList<T_user>();
        sql="select top  "+params[0]+"  * from T_user where id not in (select top  "+params[1]+"  id from T_user order by id asc)";
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = psm.executeQuery();
            if(rs!=null) {
                rs.beforeFirst();
                while (rs.next()) {
                    auat = new T_user();
                    auat.setId(rs.getInt("id"));
                    auat.setName(rs.getString("Name"));
                    auat.setTrueName(rs.getString("trueName"));
                    auat.setCardId(rs.getString("cardId"));
                    auat.setEmail(rs.getString("email"));
                    auat.setTelephone(rs.getString("telephone"));
                    auat.setQqId(rs.getString("qqId"));
                    auat.setPwd(rs.getString("pwd"));
                    auat.setRegTime(rs.getDate("regTime"));
                    auat.setQuestion(rs.getString("question"));
                    auat.setAnswer(rs.getString("answer"));
                    auat.setState(rs.getInt("state"));
                    users.add(auat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return users;
    }
//实现用户插入数据
    public int insertUser(T_user user) {
        int i = 0;
        String sql = "insert into T_user(name,trueName,cardId,email,telephone,qqId) values(?,?,?,?,?,?)";
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setString(1, user.getName());
            psm.setString(2, user.getTrueName());
            psm.setString(3, user.getCardId());
            psm.setString(4, user.getEmail());
            psm.setString(5, user.getTelephone());
            psm.setString(6, user.getQqId());
            i = psm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return i;
    }
    //实现通过id值进行查询用户信息
    public T_user findByIdFind(int uid) {
        sql="select  * from T_user where id=?";
        T_user t_user=new T_user();
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setInt(1,uid);
            rs = psm.executeQuery();
            if(rs.next()){
                t_user.setId(rs.getInt("id"));
                t_user.setName(rs.getString("Name"));
                t_user.setTrueName(rs.getString("trueName"));
                t_user.setCardId(rs.getString("cardId"));
                t_user.setEmail(rs.getString("email"));
                t_user.setTelephone(rs.getString("telephone"));
                t_user.setQqId(rs.getString("qqId"));
                t_user.setPwd(rs.getString("pwd"));
                t_user.setRegTime(rs.getDate("regTime"));
                t_user.setQuestion(rs.getString("question"));
                t_user.setAnswer(rs.getString("answer"));
                t_user.setState(rs.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return t_user;
    }
    //实现根据用户的id进行删除操作
    public int  DelById(int[] dels){
        flag= 0;
        try {
            sql="delete  from T_user where id=?";
            flag = 0;
            for(int deles :dels) {
                conn=DBConnection.getConn();
                psm = conn.prepareStatement(sql);
                System.out.println(dels);
                psm.setInt(1, deles);
                flag = psm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    //冻结用户
    public int  updateState(int id){
        flag= 0;
        try {
            sql="update  T_user set state=0   where id=?";
                conn=DBConnection.getConn();
                psm = conn.prepareStatement(sql);
                psm.setInt(1, id);
                flag = psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    //解冻用户
    public int  updateStateAble(int id) {
        flag = 0;
        try {
            sql = "update  T_user set state=1   where id=?";
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setInt(1, id);
            flag = psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    /*
    用户留言模块的信息管理
     */
        //执行分页查询(留言模块)
        public List<T_message> queryT_messageByPage(int currentPage, int PageSize) {
            int[] params={currentPage,(PageSize-1)*currentPage};
            List<T_message> messages=new ArrayList<T_message>();
            sql="select top   "+params[0]+"t.id as tid,t.title as ttitle,u.name as uname,CONVERT(varchar(100), t.time, 23) as ttime from T_message t,T_user u where t.id not in (select top  "+params[1]+"  t.id from T_message order by t.id asc) and t.userId=u.id";
            try {
                conn=DBConnection.getConn();
                psm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs = psm.executeQuery();
                if(rs!=null) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        t_message = new T_message();
                        t_message.setId(rs.getInt("tid"));
                        t_message.setTitle(rs.getString("ttitle"));
                        t_message.setTime(rs.getDate("ttime"));
                        t_message.setName(rs.getString("uname"));
                        messages.add(t_message);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                DBConnection.closeAll(rs, psm, conn);
            }
            return messages;
    }
    //根据留言id查询用户列表的详细数据
    public T_message findById_message(int uid){
        sql="select t.title ,t.time,t.content from T_message t where id=?";
         t_message=new T_message();
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setInt(1,uid);
            rs = psm.executeQuery();
            if(rs.next()){
                t_message.setTitle(rs.getString("title"));
                t_message.setTime(rs.getDate("time"));
                t_message.setContext(rs.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return t_message;
    }
    //根据留言进行批量删除操作
    public  int Del_messageInfo(int[] id){
        flag= 0;
        try {
            sql="delete from T_message where  id=?;";
            flag = 0;
            for(int deles :id) {
                conn=DBConnection.getConn();
                psm = conn.prepareStatement(sql);
                psm.setInt(1, deles);
                flag = psm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    /*
    公告信息模块
     */
    //查询单个的公告详细信息
    public T_notice manageGongGaoById(int uid ){
        sql="select * from T_notice where Id=?";
        notice=new T_notice();
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setInt(1,uid);
            rs = psm.executeQuery();
            if(rs.next()){
                notice.setId(rs.getInt("Id"));
                notice.setTitle(rs.getString("Title"));
                notice.setContent(rs.getString("Content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return notice;
    }
    //根据id信息的去更改相应的公告主体，和公告内容
    public  int updatemanageGongGaoById(int id,String title,String content){
        flag= 0;
        System.out.println(id+title+content);
        try {
            sql="update  T_notice set Title=?,Content=?  where Id=?";
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setString(1, title);
            psm.setString(2,content);
            psm.setInt(3,id);
            flag = psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    //根据id去添加公告信息
    public int insertNotice(T_notice notice){
        int i = 0;
        String sql = "insert into T_notice(Title,Content) values(?,?)";
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
            psm.setString(1, notice.getTitle());
            psm.setString(2, notice.getContent());
            i = psm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return i;
    }
    //根据id去进行删除公告操作
    public int GgDelById(int[] id){
        flag= 0;
        try {
            sql="delete from T_notice where  Id=?;";
            flag = 0;
            for(int deles :id) {
                conn=DBConnection.getConn();
                psm = conn.prepareStatement(sql);
                psm.setInt(1, deles);
                flag = psm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return flag;
    }
    /*
   实现数据的分页查询
    */
    public int getTotalCount(String sql) {
        int totalCount=-1;
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql);
             rs = psm.executeQuery();
            if(rs.next()){
                totalCount=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(rs, psm, conn);
        }
         return totalCount;
    }

    //执行分页查询(公告信息)
    public List<T_notice> queryT_noticesByPage(int currentPage,int PageSize) {
        int[] params={currentPage,(PageSize-1)*currentPage};
        List<T_notice> notices=new ArrayList<T_notice>();
        sql="select top  "+params[0]+"  * from T_notice where id not in (select top  "+params[1]+"  id from T_notice order by id asc)";
        try {
            conn=DBConnection.getConn();
            psm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = psm.executeQuery();
            if(rs!=null) {
                rs.beforeFirst();
                while (rs.next()) {
                    notice = new T_notice();
                    notice.setId(rs.getInt("Id"));
                    notice.setTitle(rs.getString("Title"));
                    notice.setContent(rs.getString("Content"));
                    notice.setTime(rs.getDate("Time"));
                    notices.add(notice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(rs, psm, conn);
        }
        return notices;
    }
}
