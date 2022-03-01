<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>

<body>
<form action="/emsys/Search?action=update" method="post">

<p><font size="5">【編集】</font></p>
<p>◆編集する社員番号を入力してください</p>

<table>
<tr><td align="right">社員番号：</td><td><input type="text" name="emp_no" maxlength="8"></td></tr>
</table>

<br>
<input type="submit" value="確認">
</form>

<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>