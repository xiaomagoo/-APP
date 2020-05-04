<%@ page import="com.entity.T_user" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020-03-19
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <style type="text/css">
        <!--
        .style1 {color: #FFFFFF}
        -->
    </style>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        <%
           T_user user1=new T_user();
           user1=(T_user) request.getSession().getAttribute("findById");
         %>
        $(document).ready(function () {
            if((<%=user1.getState()%>)>0)
            {
                $("#solve>a").text("冻结该用户");
            }else{
                $("#solve>a").text("解冻该用户");
            }
        });
                function updateState() {
                    if((<%=user1.getState()%>)>0)
                    {
                        $("#solve>a").text("冻结该用户");
                        var flag=confirm("是否冻结该用户")
                        if(flag){
                            location.href="userServlet?type=disable&id="+'<%=user1.getId()%>'+"";
                            alert("冻结成功");
                        }else{
                            alert("冻结失败！");
                        }
                    }else{
                        $("#solve>a").text("解冻该用户");
                        var flag=confirm("是否解冻该用户")
                        if(flag){
                            location.href="userServlet?type=able&id="+'<%=user1.getId()%>'+"";
                            alert("解冻成功");
                        }else{
                            alert("解冻失败！");
                        }
                    }
                }
    </script>
</head>
<body topmargin="0" leftmargin="0" bottommargin="0">
<table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">用户信息查看</div></td>
    </tr>
    <tr>
        <td height="98" bgcolor="#666666"><table width="650" border="0" align="center" cellpadding="0" cellspacing="1">
            <!--DWLayoutTable-->
            <%
                T_user user=new T_user();
                user=(T_user) request.getSession().getAttribute("findById");
            %>
            <tr>
                <td width="99" height="20" bgcolor="#FFFFFF"><div align="center">用户昵称：</div></td>
                <td width="180" bgcolor="#FFFFFF"><div align="left"><%=user.getName()%></div></td>
                <td width="100" bgcolor="#FFFFFF"><div align="center">用户状态：</div></td>
                <td width="266" bgcolor="#FFFFFF"><div align="left"><%=user.getState()==1?("未被冻结"):("被冻结")%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">真实姓名：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getTrueName()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">身份证号：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getCardId()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">E-mail：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getEmail()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">联系电话：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getTelephone()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">QQ号码：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getQqId()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">注册时间：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getRegTime()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">密码提示：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getQuestion()%></div></td>
            </tr>
            <tr>
                <td height="20" bgcolor="#FFFFFF"><div align="center">密码提示答案：</div></td>
                <td colspan="3" bgcolor="#FFFFFF"><div align="left"><%=user.getAnswer()%></div></td>
            </tr>
        </table></td>
    </tr>

    <tr>
        <td height="20"><div align="center" id="solve"><a href="javascript:void(0)" onclick="updateState()">
            冻结该用户</a></div></td>
    </tr>
</table>
</body>
</html>
