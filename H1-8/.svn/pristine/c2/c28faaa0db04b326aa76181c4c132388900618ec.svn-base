<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.T_user" %>
<%@ page import="com.entity.T_message" %>
<%@ page import="com.entity.Page" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020-03-18
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户留言管理</title>
    <link  rel="stylesheet" type="text/css" href="css/font.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            if((<%=session.getAttribute("del_message")%>)>0){
                alert("成功删除"+(<%=request.getSession().getAttribute("del_message")%>)+"条留言！");
            }
            <%session.setAttribute("del_message",0);%>
        });
    </script>
</head>

<body topmargin="0" leftmargin="0" bottommargin="0">
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
    <form name="form1" method="post" action="userServlet?type=del_message">
        <tr bgcolor="#FFCF60">
            <td height="20" colspan="2"><div align="center"><font color="#FFFFFF">用户留言管理</font></div></td>
        </tr>
        <tr>
            <td height="40" colspan="2" bgcolor="#333333"><table width="750"  border="0" align="center" cellpadding="0" cellspacing="1">
                <tr>
                    <td width="357" height="20" bgcolor="#FFFFFF"><div align="center">留言主题</div></td>
                    <td width="80" bgcolor="#FFFFFF"><div align="center">留言者</div></td>
                    <td width="156" bgcolor="#FFFFFF"><div align="center">留言时间</div></td>
                    <td width="93" bgcolor="#FFFFFF"><div align="center">操作</div></td>
                    <td width="58" bgcolor="#FFFFFF"><div align="center">删除</div></td>
                </tr>
                <%
                    Page page1=new Page();
                    page1= (Page) session.getAttribute("listMessage");
                    List<T_message> messages=new ArrayList<T_message>();
                    messages=page1.getMessageList();
                    for(int i=0;i<messages.size();i++){
                %>
                <tr>
                    <td height="20" bgcolor="#FFFFFF"><div align="left"><%=messages.get(i).getTitle()%></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><%=messages.get(i).getName()%>
                    </div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><%=messages.get(i).getTime()%></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><a href="userServlet?type=findById_message&uid=<%=messages.get(i).getId()%>">查看</a></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">
                        <input type="checkbox" name="del_message" value="<%=messages.get(i).getId()%>">
                    </div></td>
                </tr>
                <%}%>
            </table></td>
        </tr>
        <tr height="15px">
            <td></td>
        </tr>
        <tr >
            <td width="100%" bgcolor="#FFFFFF" align="right">
                <input type="submit" value="删除选项" class="buttoncss"></td>
        </tr>
    </form>
</table>
<table width="200" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <%
            if(page1.getCurrentPage()==1&&(page1.getTotalPage()!=1&&page1.getTotalPage()!=0)){
        %>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
        <%}
        else if(page1.getCurrentPage()==page1.getTotalPage()&&(page1.getTotalPage()!=1&&page1.getTotalPage()!=0)){
        %>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
        <% }
        else if(page1.getCurrentPage()!=1||page1.getCurrentPage()!=page1.getTotalPage()&&page1.getTotalPage()!=0){
        %>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
        <td align="center"><a  href="userServlet?type=listOfMessage&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
        <%}%>
    </tr>
</table>
</body>
</html>