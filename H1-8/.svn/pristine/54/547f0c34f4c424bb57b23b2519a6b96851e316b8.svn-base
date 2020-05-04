package com.servlet;

import com.dao.UserDao;
import com.entity.T_message;
import com.entity.T_notice;
import com.entity.T_user;
import com.service.UserService;
import com.entity.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    String type="",flag,nicheng,truename,cardid,email,telephone,qq,title,content;
    private HashMap<String,Object> hm=new HashMap<String,Object>();
    UserService userService=new UserService();
    T_user t_user=null;
    UserDao userDao=new UserDao();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.work(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.work(request, response);
    }

    protected void work(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int flag=0;
        PrintWriter out = response.getWriter();
        T_message t_message=null;
        ArrayList<T_notice> notices=null;
        ArrayList<T_user> users=null;
        T_notice tNotice=null;
        type=request.getParameter("type");
        /*
        模块：用户信息管理
        涉及功能：实现用户的增删改查
        涉及数据库：ShopDB
        涉及表：T_user
         */
        //添加用户
        if (type.equals("addUser")) {
            nicheng = request.getParameter("nicheng");
            truename = request.getParameter("truename");
            cardid = request.getParameter("cardid");
            email =request.getParameter("email");
            telephone = request.getParameter("telephone");
            qq = request.getParameter("qq");
            t_user = new T_user();
            //获取前端输入的值
            t_user.setName(nicheng);
            t_user.setTrueName(truename);
            t_user.setCardId(cardid);
            t_user.setEmail(email);
            t_user.setTelephone(telephone);
            t_user.setQqId(qq);
            int i = userService.insertUser(t_user);
            if(i>0){
                request.getSession().setAttribute("addFlag",i);
                response.sendRedirect("AddUser.jsp");
            }else{
                response.sendRedirect("AddUser.jsp");
            }
        }
        //查询所有用户
        if(type.equals("list")){
            String pageSize=request.getParameter("pageSize");
            String currentPage=request.getParameter("currentPage");
            if(pageSize==null||currentPage==null){
                pageSize="10";
                currentPage="1";
            }
            int pageSizeOne=Integer.parseInt(pageSize);
            int currentPageOne=Integer.parseInt(currentPage);
            users=new ArrayList<T_user>();
            users= (ArrayList<T_user>) userDao.queryT_usersByPage(pageSizeOne,currentPageOne);
            //将分页需要的五个对象，组装到Page对象中去,实际只需要四个，一个自动计算
            Page page=new Page();
            int count=userDao.getTotalCount("select count(1) from T_user");
            page.setTotalCount(count);
            page.setPageSize(pageSizeOne);
            page.setCurrentPage(currentPageOne);
            page.setUsers(users);
            request.getSession().setAttribute("page",page);
            response.sendRedirect("ManageUser.jsp");
        }
        //根据id进行查询单个用户的所有信息
        if(type.equals("byIdFind")){
            T_user  user=new T_user();
            String id=request.getParameter("id");
            int uid=Integer.parseInt(id);
             user= userService.findByIdFind(uid);
             request.getSession().setAttribute("findById",user);
            response.sendRedirect("LookUserinfo.jsp");
        }
        //根据用户的id进行删除用户操作
        if(type.equals("delById")) {
            String[] del = request.getParameterValues("dels");
            if ( del !=null) {
                int[] delInt = new int[del.length];
                int i;
                System.out.println(delInt);
                for (i = 0; i < del.length; i++) {
                    delInt[i] = Integer.parseInt(del[i]);
                    System.out.println(delInt[i]);
                }
                flag = userService.DelById(delInt);
                request.getSession().setAttribute("delmeg", i);
                if (flag > 0) {
                    System.out.println("成功删除" + i + "条数据！");
                    response.sendRedirect("userServlet?type=list");
                } else {
                    System.out.println("删除失败");
                    response.sendRedirect("userServlet?type=list");
                }
            }else{
                JOptionPane.showMessageDialog(null,"您还未选择删除项，请重新操作!");
                response.sendRedirect("userServlet?type=list");
            }
        }
        //实现冻结用户
        if(type.equals("disable")){
            String updateState=request.getParameter("id");
            int id=Integer.parseInt(updateState);
            flag=userService.updateState(id);
            if(flag>0){
                request.getSession().setAttribute("flag",flag);
                response.sendRedirect("userServlet?type=byIdFind&id="+id+"");
            }else{
                response.sendRedirect("userServlet?type=byIdFind&id="+id+"");
            }

        }
        //实现解冻用户
        if(type.equals("able")){
            String updateStateAble=request.getParameter("id");
            int id=Integer.parseInt(updateStateAble);
            flag=userService.updateStateAble(id);
            if(flag>0){
                request.getSession().setAttribute("flag",flag);
                response.sendRedirect("userServlet?type=byIdFind&id="+id+"");
            }else{
                response.sendRedirect("userServlet?type=byIdFind&id="+id+"");
            }
        }
        /*
        用户留言信息管理
        涉及数据库：ShopDB
        涉及的表：T_message
         */
        //查询所有用户的留言信息列表
        if(type.equals("listOfMessage")){
            String pageSize=request.getParameter("pageSize");
            String currentPage=request.getParameter("currentPage");
            System.out.println(pageSize+currentPage);
            if(pageSize==null||currentPage==null){
                pageSize="10";
                currentPage="1";
            }
            int pageSizeOne=Integer.parseInt(pageSize);
            int currentPageOne=Integer.parseInt(currentPage);
            ArrayList<T_message> listMessage=new ArrayList<T_message>();
            listMessage= (ArrayList<T_message>) userDao.queryT_messageByPage(pageSizeOne,currentPageOne);
            //将分页需要的五个对象，组装到Page对象中去,实际只需要四个，一个自动计算
            Page page=new Page();
            int count=userDao.getTotalCount("select count(1) from T_message");
            page.setTotalCount(count);
            page.setPageSize(pageSizeOne);
            page.setCurrentPage(currentPageOne);
            page.setMessageList(listMessage);
            request.getSession().setAttribute("listMessage",page);
            response.sendRedirect("manageLeaveword.jsp");
        }
        //通过id属性查询留言的详细信息
        if(type.equals("findById_message")) {
             t_message=new T_message();
             String uid=request.getParameter("uid");
             int fuid=Integer.parseInt(uid);
            t_message=userDao.findById_message(fuid);
            request.getSession().setAttribute("findById_message",t_message);
            response.sendRedirect("leavewordInfo.jsp");
        }
        //删除用户留言列表的留言
        if(type.equals("del_message")){
            String[] del = request.getParameterValues("del_message");
            if ( del !=null) {
                int[] delInt = new int[del.length];
                int i;
                for (i = 0; i < del.length; i++) {
                    delInt[i] = Integer.parseInt(del[i]);
                }
                flag = userService.Del_messageInfo(delInt);
                request.getSession().setAttribute("del_message", i);
                if (flag > 0) {
                    System.out.println("成功删除" + i + "条数据！");
                    response.sendRedirect("userServlet?type=listOfMessage");
                } else {
                    System.out.println("删除失败");
                    response.sendRedirect("userServlet?type=listOfMessage");
                }
            }else{
                JOptionPane.showMessageDialog(null,"您还未选择删除项，请重新操作!");
                response.sendRedirect("userServlet?type=listOfMessage");
            }
        }
        /*
        公告信息模块
         */
        //公告信息列表显示
        if(type.equals("manageGongGao")){
            String pageSize=request.getParameter("pageSize");
            String currentPage=request.getParameter("currentPage");
            System.out.println(pageSize+currentPage);
            if(pageSize==null||currentPage==null){
                pageSize="10";
                currentPage="1";
            }
            int pageSizeOne=Integer.parseInt(pageSize);
            int currentPageOne=Integer.parseInt(currentPage);
            notices=new ArrayList<T_notice>();
            notices= (ArrayList<T_notice>) userDao.queryT_noticesByPage(pageSizeOne,currentPageOne);
            //将分页需要的五个对象，组装到Page对象中去,实际只需要四个，一个自动计算
            Page page=new Page();
            int count=userDao.getTotalCount("select count(1) from T_notice");
            page.setTotalCount(count);
            page.setPageSize(pageSizeOne);
            page.setCurrentPage(currentPageOne);
            page.setNotices(notices);
            request.getSession().setAttribute("pageGonggao",page);
            response.sendRedirect("manageGonggao.jsp");
        }
        //根据id查询公告的详细信息
        if(type.equals("manageGongGaoById")){
            T_notice  notice=new T_notice();
            String id=request.getParameter("id");
            int uid=Integer.parseInt(id);
            notice= userService.manageGongGaoById(uid);
            request.getSession().setAttribute("fmanageGongGaoById",notice);
            response.sendRedirect("editGonggao.jsp");
        }
        //根据id信息的去更改相应的公告主体，和公告内容
        if(type.equals("updatemanageGongGaoById")){
            String uid=request.getParameter("id");
            String title=request.getParameter("title");
            String content=request.getParameter("content");
            int id=Integer.parseInt(uid);
            flag=userService.updatemanageGongGaoById(id,title,content);
            if(flag>0){
                request.getSession().setAttribute("ggflag",flag);
                response.sendRedirect("userServlet?type=manageGongGaoById&id="+id+"");
            }else{
                response.sendRedirect("userServlet?type=manageGongGaoById&id="+id+"");
            }
        }
        if(type.equals("addGonggao")){
            title=request.getParameter("title");
            content=request.getParameter("content");
            tNotice = new T_notice();
            //获取前端输入的值
           tNotice.setTitle(title);
           tNotice.setContent(content);
            int i = userService.insertNotice(tNotice);
            if(i>0){
                request.getSession().setAttribute("addFlagNo",i);
                response.sendRedirect("addGonggao.jsp");
            }else{
                response.sendRedirect("addGonggao.jsp");
            }
        }
        //根据id去删除公告信息
        if(type.equals("deleteGonggaoById")){
            String[] delGonggao = request.getParameterValues("delGonggao");
            if ( delGonggao !=null) {
                int[] delInt = new int[delGonggao.length];
                int i;
                System.out.println(delInt);
                for (i = 0; i < delGonggao.length; i++) {
                    delInt[i] = Integer.parseInt(delGonggao[i]);
                   System.out.println(delInt[i]);
                }
                flag = userService.GgDelById(delInt);
                request.getSession().setAttribute("delGonggaomeg", i);
                if (flag > 0) {
                    System.out.println("成功删除" + i + "条数据！");
                    response.sendRedirect("userServlet?type=manageGongGao");
                } else {
                    System.out.println("删除失败");
                    response.sendRedirect("userServlet?type=manageGongGao");
                }
            }else{
                JOptionPane.showMessageDialog(null,"您还未选择删除项，请重新操作!");
                response.sendRedirect("userServlet?type=manageGongGao");
            }
        }
    }
}
