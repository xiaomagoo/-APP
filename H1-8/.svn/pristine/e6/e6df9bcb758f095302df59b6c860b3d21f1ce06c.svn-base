<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020-04-01
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑公告</title>
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <style type="text/css">
        <!--
        .style1 {color: #FFFFFF}
        -->
    </style>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            if((<%=session.getAttribute("addFlagNo")%>)>0){
                var flag=confirm("是否继续插入新公告？");
                if(flag){
                    window.location.href="addGonggao.jsp";
                }else{
                    window.location.href="userServlet?type=manageGongGao";
                }
                <%session.setAttribute("addFlagNo",0);%>
            }
        });
    </script>
</head>
<body topmargin="0" leftmargin="0" bottommargin="0">
<table width="750" border="0" align="center" cellspacing="0">
    <tr>
        <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">添加公告</div></td>
    </tr>
    <tr>
        <td bgcolor="#666666"><table width="750" border="0" align="center" cellpadding="0" cellspacing="1">
            <form name="form1" method="post" action="userServlet?type=addGonggao" >

                <tr>
                    <td width="100" height="25" bgcolor="#FFFFFF"><div align="center">公告主题</div></td>
                    <td width="647" height="25" bgcolor="#FFFFFF"><div align="left">
                        <input type="text" name="title" size="50" class="inputcss" placeholder="请输入您要添加的公告主题"> <font color="red">*</font></div></td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF"><div align="center">公告内容：</div></td>
                    <td bgcolor="#FFFFFF"><div align="left">
                        <textarea name="content" cols="60" rows="8" class="inputcss" placeholder="请您输入要添加的该公告内容"></textarea> <font color="red">*</font>
                    </div></td>
                </tr>
                <tr>
                    <td height="25" colspan="2" bgcolor="#FFFFFF"><div align="center"><input type="hidden" name="id" value="4"><input type="submit" value="添加" class="buttoncss">&nbsp;&nbsp;<input type="reset" value="重写" class="buttoncss"></div></td>
                </tr>
            </form>
        </table></td>
    </tr>
</table>
</body>
</html>
