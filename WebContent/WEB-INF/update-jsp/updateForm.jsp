<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.SearchUser"%>
<%
SearchUser searchUser = (SearchUser) session.getAttribute("searchUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>

<body>
	<form action="/emsys/UpdateUser" method="post">

		<p>
			<font size="5">【編集】</font>
		</p>
		<p>◆編集する内容を入力してください</p>

		<table>
			<tr>
				<td>社員番号：</td>
				<td><input type="text" name="emp_no_after" maxlength="8"
					value=<%=searchUser.getEmpNo()%> required> <input
					type="hidden" name="emp_no" value=<%=searchUser.getEmpNo()%>></td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td><input type="text" name="emp_name"
					value=<%=searchUser.getEmpName()%> required></td>
			</tr>
			<tr>
				<td>よみかな：</td>
				<td><input type="text" name="emp_kana"
					value=<%=searchUser.getEmpKana()%> required></td>
			</tr>
			<tr>
				<td>入社日：</td>
				<td><input type="date" name="hire_ymd"
					value=<%=searchUser.getHireYmd()%>></td>
			</tr>

			<tr>
				<td>退職日：</td>
				<td><input type="date" name="retirement_ymd"
					value=<%=searchUser.getRetirementYmd()%>></td>
			</tr>

			<tr>
				<td>所属部署：</td>
				<td><select name="department_data">
						<%
						if (searchUser.getDepartmentData() == "") {
						%>
						<option value="">所属部署を選択してください</option>
						<%
						} else {
						%>
						<option value=<%=searchUser.getDepartmentData()%>><%=searchUser.getDepartmentData()%></option>
						<%
						}
						%>
						<option value="システム開発部">システム開発部</option>
						<option value="基盤技術部">基盤技術部</option>
						<option value="ITM部">ITM部</option>
				</select></td>

			</tr>
			<tr>
				<td>Mail：</td>
				<td><input type="text" name="mail_add"
					value=<%=searchUser.getMailAdd()%> required></td>
			</tr>
			<tr>
				<td>編集者：</td>
				<td><input type="text" name="update_person"
					value=<%=searchUser.getUpdatePerson()%> required></td>
			</tr>
		</table>

		<br> <input type="submit" value="確認">
	</form>

	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>