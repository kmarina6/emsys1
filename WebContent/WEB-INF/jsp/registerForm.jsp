<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>
<form action="/emsys/RegisterUser" method="post">

<p><font size="5">【登録】</font></p>
<p>◆入力フォームに入力してください</p>

<table>
<tr><td align="right">社員番号：</td><td><input type="text" name="emp_no" maxlength="8"></td></tr>
<tr><td align="right">氏名：</td><td><input type="text" name="emp_name" ></td></tr>
<tr><td align="right">よみかな：</td><td><input type="text" name="emp_kana"></td></tr>
<tr><td align="right">入社日：</td><td><input type="text" name="hire_y" maxlength="4" style="width:30px;"> /
<input type="text" name="hire_m" maxlength="2" style="width:15px;"> /
<input type="text" name="hire_d" maxlength="2" style="width:15px;"></td></tr>
<tr><td align="right">所属部署：</td><td><input type="text" name="department_data"></td></tr>
<tr><td align="right">Mail：</td><td><input type="text" name="mail_add"></td></tr>
<tr><td align="right">登録者：</td><td><input type="text" name="registered_person"></td></tr>
</table>

<br>
<input type="submit" value="確認">
</form>

<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>