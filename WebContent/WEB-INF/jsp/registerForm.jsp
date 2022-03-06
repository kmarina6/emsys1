<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>
	<form action="/emsys/RegisterUser" method="post">

		<p>
			<font size="5">【登録】</font>
		</p>
		<p>◆入力フォームに入力してください</p>

		<table>
			<tr>
				<td align="right">社員番号：</td>
				<td><input type="text" name="emp_no" maxlength="8" required></td>
			</tr>
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="emp_name" required></td>
			</tr>
			<tr>
				<td align="right">よみかな：</td>
				<td><input type="text" name="emp_kana" required></td>
			</tr>
			<tr>
				<td align="right">入社日：</td>
				<td><input type="date" name="hire_ymd"></td>
			</tr>
			<tr>
				<td align="right">所属部署：</td>
				<td><select name="department_data">
						<option value="">所属部署を選択してください</option>
						<option value="システム開発部">システム開発部</option>
						<option value="基盤技術部">基盤技術部</option>
						<option value="ITM部">ITM部</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">Mail：</td>
				<td><input type="text" name="mail_add" required></td>
			</tr>
			<tr>
				<td align="right">登録者：</td>
				<td><input type="text" name="registered_person" required></td>
			</tr>
		</table>

		<br> <input type="submit" value="確認">
	</form>

	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>