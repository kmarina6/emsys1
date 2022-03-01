<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.UserToUpdate" %>
<%UserToUpdate updateUser = (UserToUpdate) session.getAttribute("updateUser");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>

<body>
<p><font size="5">【編集】</font></p>
<p>下記のユーザーの変更を登録します。</p>


<table>
<tr><td align="right">社員番号：</td><td><%= updateUser.getEmpNo()%></td></tr>
<tr><td align="right">氏名：</td><td><%= updateUser.getEmpName()%></td></tr>
<tr><td align="right">よみかな：</td><td><%= updateUser.getEmpKana()%></td></tr>
<tr><td align="right">入社日：</td><td><%= updateUser.getHireY()%>/<%= updateUser.getHireM()%>/<%= updateUser.getHireD()%></td></tr>
<tr><td align="right">退職日：</td><td><%= updateUser.getRetirementY()%>/<%= updateUser.getRetirementM()%>/<%= updateUser.getRetirementD()%></td></tr>

<tr><td align="right">所属部署：</td><td><%= updateUser.getDepartmentData()%></td></tr>
<tr><td align="right">Mail：</td><td><%= updateUser.getMailAdd()%></td></tr>
<tr><td align="right">編集者：</td><td><%= updateUser.getUpdatePerson()%></td></tr>
</table>

<br>
<a href="/emsys/Search?action=update">戻る</a>
<a href="/emsys/UpdateUser?action=done">登録</a>
</body>
</html>