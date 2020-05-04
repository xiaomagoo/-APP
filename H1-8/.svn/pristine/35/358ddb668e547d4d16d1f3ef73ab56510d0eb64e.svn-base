<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.T_notice" %>
<%@ page import="com.entity.Page" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020-04-01
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>公告管理</title>
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <style type="text/css">
        <!--
        .style1 {color: #FFFFFF}
        -->
    </style>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                if((<%=session.getAttribute("delGonggaomeg")%>)>0){
                    alert("成功删除"+(<%=request.getSession().getAttribute("delGonggaomeg")%>)+"条公告！");
                    <%session.setAttribute("delGonggaomeg",0);%>
                }
            });
    </script>
</head>

<body topmargin="0" leftmargin="0" bottommargin="0">
<form name="form1" method="post" action="userServlet?type=deleteGonggaoById">
    <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">公告管理</div></td>
        </tr>
        <tr>
            <td height="50" bgcolor="#666666"><table width="750" height="25" border="0" align="center" cellpadding="0" cellspacing="1">
                <tr>
                    <td width="50" height="25" bgcolor="#FFFFFF"><div align="center">复选</div></td>
                    <td width="621" bgcolor="#FFFFFF"><div align="center">公告主题</div></td>
                    <td width="75" bgcolor="#FFFFFF"><div align="center">操作</div></td>
                </tr>
                <%
                    Page page1=new Page();
                    page1= (Page) session.getAttribute("pageGonggao");
                    List<T_notice> notices=new ArrayList<T_notice>();
                    notices=page1.getNotices();
                    for(int i=0;i<notices.size();i++){
                %>
                <tr>
                    <td height="25" bgcolor="#FFFFFF"><div align="center"><input type="checkbox" name="delGonggao" value="<%=notices.get(i).getId()%>"></div></td>
                    <td height="25" bgcolor="#FFFFFF"><div align="left"><%=notices.get(i).getTitle()%></div></td>
                    <td height="25" bgcolor="#FFFFFF"><div align="center"><a href="userServlet?type=manageGongGaoById&id=<%=notices.get(i).getId()%>">查看编辑</a></div></td>
                </tr>
                <%}%>
            </table></td>
        </tr>
    </table>
    <br>
    <table width="750" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
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
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
            <%}
            else if(page1.getCurrentPage()==page1.getTotalPage()&&(page1.getTotalPage()!=1&&page1.getTotalPage()!=0)){
            %>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
            <% }
            else if(page1.getCurrentPage()!=1||page1.getCurrentPage()!=page1.getTotalPage()&&page1.getTotalPage()!=0){
            %>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=1" class="buttoncss">首页</a></td>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getCurrentPage()-1%>" class="buttoncss">< 上一页</a></td>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getCurrentPage()+1%>" class="buttoncss">下一页 ></a></td>
            <td align="center"><a  href="userServlet?type=manageGongGao&pageSize=10&currentPage=<%=page1.getTotalPage()%>" class="buttoncss">尾页</a></td>
            <%}%>
        </tr>
    </table>
</form>
</body>
</html>
