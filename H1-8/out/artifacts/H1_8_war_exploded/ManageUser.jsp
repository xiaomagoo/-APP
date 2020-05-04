<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.T_user" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <style type="text/css">
        <!--
        .style1 {color: #FFFFFF}
        -->
    </style>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            if((<%=session.getAttribute("delmeg")%>)>0){
                alert("成功删除"+(<%=request.getSession().getAttribute("delmeg")%>)+"条数据！");
                <%session.setAttribute("delmeg",0);%>
            }
        });
    </script>
</head>

<body topmargin="0" leftmargin="0" bottommargin="0">


<form name="form1" method="post" action="userServlet?type=delById">
    <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">

        <tr>
            <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">用户管理</div></td>
        </tr>
        <tr>
            <td  bgcolor="#666666"><table width="600" border="0" align="center" cellpadding="0" cellspacing="1">
                <tr>
                    <td width="224" height="20" bgcolor="#FFFFFF"><div align="center">用户昵称</div></td>
                    <td width="93" bgcolor="#FFFFFF"><div align="center">用户状态</div></td>
                    <td width="79" bgcolor="#FFFFFF"><div align="center">删除</div></td>
                    <td width="75" bgcolor="#FFFFFF"><div align="center">查看信息</div></td>
                </tr>
                <%
                    Page page1=new Page();
                    page1= (Page) session.getAttribute("page");
                    List<T_user> users=new ArrayList<T_user>();
                    users=page1.getUsers();
                for(int i=0;i<users.size();i++){
                %>
                <tr>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><%=users.get(i).getName()%></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">
                       <%=(users.get(i).getState()==0)?("被冻结"):("未被冻结")%>
                    </div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">
                        <input type="checkbox" name="dels" value=<%=users.get(i).getId()%>></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><a href="userServlet?type=byIdFind&id=<%=users.get(i).getId()%>"><img src="images/button_select.png" width="14" height="13" border="0"></a></div></td>
                </tr>
                <%}%>
            </table></td>
        </tr>
    </table>
    <br>
    <table width="600" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>

            <td align="right">
                <input type="submit" value="删除选项" class="buttoncss">
            </td>
        </tr>
    </table>
    <table width="200" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
        <%
            if(page1.getCurrentPage()==1&&(page1.getTotalPage()!=1&&page1.getTotalPage()!=0)){
                System.out.println(page1.getTotalPage());
                %>
            <td align="center"><a  href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
            <td align="center"><a href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
            <%}
            else if(page1.getCurrentPage()==page1.getTotalPage()&&(page1.getTotalPage()!=1&&page1.getTotalPage()!=0)){
                %>
            <td align="center"><a  href="userServlet?type=list&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
            <td align="center"><a href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
            <% }
            else if(page1.getCurrentPage()!=1||page1.getCurrentPage()!=page1.getTotalPage()&&page1.getTotalPage()!=0){
                %>
            <td align="center"><a  href="userServlet?type=list&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
            <td align="center"><a href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
            <td align="center"><a  href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
            <td align="center"><a href="userServlet?type=list&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
          <%}%>
        </tr>
    </table>
</form>
</body>
</html>
