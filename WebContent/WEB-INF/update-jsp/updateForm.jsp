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
				<td align="right">社員番号：</td>
				<td><input type="text" name="emp_no_after" maxlength="8"
					value=<%=searchUser.getEmpNo()%>> <input type="hidden"
					name="emp_no" value=<%=searchUser.getEmpNo()%>></td>
			</tr>
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="emp_name"
					value=<%=searchUser.getEmpName()%>></td>
			</tr>
			<tr>
				<td align="right">よみかな：</td>
				<td><input type="text" name="emp_kana"
					value=<%=searchUser.getEmpKana()%>></td>
			</tr>
			<tr>
				<td align="right">入社日：</td>
				<td><input type="text" name="hire_y"
					value=<%=searchUser.getHireY()%> maxlength="4"
					style="width: 30px;"> / <input type="text" name="hire_m"
					value=<%=searchUser.getHireM()%> maxlength="2"
					style="width: 15px;"> / <input type="text" name="hire_d"
					value=<%=searchUser.getHireD()%> maxlength="2"
					style="width: 15px;"></td>
			</tr>


			<tr>
				<td align="right">退職日：</td>
				<td><input type="text" name="retirement_y"
					value=<%=searchUser.getRetirementY()%> maxlength="4"
					style="width: 30px;"> / <input type="text" name="retirement_m"
					value=<%=searchUser.getRetirementM()%> maxlength="2"
					style="width: 15px;"> / <input type="text" name="retirement_d"
					value=<%=searchUser.getRetirementD()%> maxlength="2"
					style="width: 15px;"></td>
			</tr>

			<tr>
				<td align="right">所属部署：</td>
				<td><input type="text" name="department_data"
					value=<%=searchUser.getDepartmentData()%>></td>
			</tr>
			<tr>
				<td align="right">Mail：</td>
				<td><input type="text" name="mail_add"
					value=<%=searchUser.getMailAdd()%>></td>
			</tr>
			<tr>
				<td align="right">編集者：</td>
				<td><input type="text" name="update_person"
					value=<%= searchUser.getUpdatePerson()%>></td>
			</tr>
		</table>

		<br> <input type="submit" value="確認">
	</form>

	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>