<%@ page import="com.entity.T_user" %>
<%@ page import="com.entity.T_message" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020-03-19
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑留言</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/font.css">
</head>
<body topmargin="0" leftmargin="0" bottommargin="0" >


<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">

    <tr>
        <td height="20" bgcolor="#FFCF60"><div align="center"><font color="#FFFFFF">查看留言</font></div></td>
    </tr>
    <tr>
        <td height="100" bgcolor="#000000"><table width="750" height="100" border="0" align="center" cellpadding="0" cellspacing="1">
           <%T_message t_message= (T_message) request.getSession().getAttribute("findById_message");
             request.getSession().setAttribute("message",t_message.getContext());
           %>
            <tr>
                <td width="87" height="25" bgcolor="#FFFFFF"><div align="center">留言主题:</div></td>
                <td width="392" height="25" bgcolor="#FFFFFF"><div align="left"><%=t_message.getTitle()%></div></td>
                <td width="83" bgcolor="#FFFFFF"><div align="center">留言时间:</div></td>
                <td width="183" bgcolor="#FFFFFF"><div align="center"><%=t_message.getTime()%></div></td>
            </tr>
            <tr>
                <td height="100" bgcolor="#FFFFFF"><div align="center">留言内容:</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left">
                    <%=t_message.getContext()%> </div></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td height="20"><div align="center">&nbsp;<input type="button" value="返回" class="buttoncss" onClick="javascript:location.href='userServlet?type=listOfMessage';"></div></td>
    </tr>

</table>
</body>
</html>