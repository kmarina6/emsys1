<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%User registerUser = (User) session.getAttribute("registerUser");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>
<p><font size="5">【登録】</font></p>
<p>下記のユーザーを登録します。</p>


<table>
<tr><td align="right">社員番号：</td><td><%= registerUser.getEmpNo()%></td></tr>
<tr><td align="right">氏名：</td><td><%= registerUser.getEmpName()%></td></tr>
<tr><td align="right">よみかな：</td><td><%= registerUser.getEmpKana()%></td></tr>
<tr><td align="right">入社日：</td><td><%= registerUser.getHireY()%>/<%= registerUser.getHireM()%>/<%= registerUser.getHireD()%></td></tr>
<tr><td align="right">所属部署：</td><td><%= registerUser.getDepartmentData()%></td></tr>
<tr><td align="right">Mail：</td><td><%= registerUser.getMailAdd()%></td></tr>
<tr><td align="right">登録者：</td><td><%= registerUser.getRegisteredPerson()%></td></tr>
</table>

<br>
<a href="/emsys/RegisterUser">戻る</a>
<a href="/emsys/RegisterUser?action=done">登録</a>
</body>
</html>