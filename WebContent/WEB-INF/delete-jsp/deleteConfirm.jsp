<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.SearchUser"%>
<%
SearchUser searchUser = (SearchUser) session.getAttribute("searchUser");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除</title>
</head>

<body>
<p><font size="5">【削除】</font></p>
<p>下記のユーザーを削除します。</p>

<table>
<tr><td align="right">社員番号：</td><td><%= searchUser.getEmpNo()%></td></tr>
<tr><td align="right">氏名：</td><td><%= searchUser.getEmpName()%></td></tr>
<tr><td align="right">よみかな：</td><td><%= searchUser.getEmpKana()%></td></tr>
<tr><td align="right">入社日：</td><td><%= searchUser.getHireY()%>/<%= searchUser.getHireM()%>/<%= searchUser.getHireD()%></td></tr>
<tr><td align="right">所属部署：</td><td><%= searchUser.getDepartmentData()%></td></tr>
<tr><td align="right">Mail：</td><td><%= searchUser.getMailAdd()%></td></tr>
<tr><td align="right">更新日：</td><td><%= searchUser.getUpdateDate()%></td></tr>
<tr><td align="right">更新者：</td><td><%= searchUser.getUpdatePerson()%></td></tr>
<tr><td align="right">登録日：</td><td><%= searchUser.getRegisteredDate()%></td></tr>
<tr><td align="right">登録者：</td><td><%= searchUser.getRegisteredPerson()%></td></tr>
</table>

<br>
<a href="/emsys/Search?action=delete">戻る</a>
<a href="/emsys/DeleteUser?action=done">削除</a>
</body>
</html>