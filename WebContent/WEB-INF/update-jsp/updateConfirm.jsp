<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.UserToUpdate"%>
<%
UserToUpdate updateUser = (UserToUpdate) session.getAttribute("updateUser");
%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/submitButton.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>

<body>
	<p>
		<font size="5">【編集】</font>
	</p>
	<p>下記のユーザーの変更を登録します。</p>


	<table>
		<tr>
			<td align="right">社員番号：</td>
			<td><%=updateUser.getEmpNoAfter()%></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td><%=updateUser.getEmpName()%></td>
		</tr>
		<tr>
			<td align="right">よみかな：</td>
			<td><%=updateUser.getEmpKana()%></td>
		</tr>
		<tr>
			<td align="right">入社日：</td>
			<td><%=updateUser.getHireYmd().replaceAll("-", "/").replaceAll("null", "")%></td>
		</tr>
		<tr>
			<td align="right">退職日：</td>
			<td><%=updateUser.getRetirementYmd().replaceAll("-", "/").replaceAll("null", "")%></td>
		</tr>

		<tr>
			<td align="right">所属部署：</td>
			<td><%=updateUser.getDepartmentData().replaceAll("null", "")%></td>
		</tr>
		<tr>
			<td align="right">Mail：</td>
			<td><%=updateUser.getMailAdd()%></td>
		</tr>
		<tr>
			<td align="right">編集者：</td>
			<td><%=updateUser.getUpdatePerson()%></td>
		</tr>
	</table>

	<br>
	<input type="button" id="btnSubmit"
		onclick="location.href='http://localhost:8080/emsys/UpdateUser?action=done';checkDoubleSubmit()"
		value="登録">
	<br>
	<a href="/emsys/InquiryServlet">戻る</a>
</body>
</html>