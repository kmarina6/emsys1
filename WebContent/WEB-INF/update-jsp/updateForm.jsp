<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="model.SearchUser"%>
<%
SearchUser searchUser = (SearchUser) session.getAttribute("searchUser");
%>
<%@ page import="bean.DepartmentBean"%>
<%
ArrayList<DepartmentBean> depBeanList = (ArrayList<DepartmentBean>) request.getAttribute("depBeanList");
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
		<p>◆編集する内容を入力してください<br>
		<font size="2">*マークは必須項目です</font>
		</p>

		<table>
			<tr>
				<td>社員番号：</td>
				<td><input type="text" name="emp_no_after" maxlength="8"
					pattern="[0-9]{8}" title="8桁の半角数字のみで入力して下さい。"
					value=<%=searchUser.getEmpNo()%> required>
					<input type="hidden" name="emp_no" value=<%=searchUser.getEmpNo()%>>
				*</td>
			</tr>
			<tr>
				<td>氏名：</td>
				<td><input type="text" name="emp_name"
					value=<%=searchUser.getEmpName()%> required>*</td>
			</tr>
			<tr>
				<td>よみかな：</td>
				<td><input type="text" name="emp_kana"
					value=<%=searchUser.getEmpKana()%> required>*</td>
			</tr>
			<tr>
				<td>入社日：</td>
				<td><input type="date" min="1952-01-01" name="hire_ymd"
					value=<%=searchUser.getHireYmd()%>></td>
			</tr>

			<tr>
				<td>退職日：</td>
				<td><input type="date" min="1952-01-01" name="retirement_ymd"
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
						} // end else
						%>
						<%
						for (DepartmentBean depBean : depBeanList) {
						%>
						<option value=<%=depBean.getJobName()%>><%=depBean.getJobName()%>
						</option>
						<%
						} // endfor
						%>
				</select></td>

			</tr>
			<tr>
				<td>Mail：</td>
				<td><input type="text"
					pattern="^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\.)+[a-zA-Z]{2,}$"
					title="メールアドレスは、aaa@example.comのような形で入力してください。" name="mail_add"
					value=<%=searchUser.getMailAdd()%> required>*</td>
			</tr>
			<tr>
				<td>編集者：</td>
				<td><input type="text" name="update_person"
					value=<%=searchUser.getUpdatePerson()%> required>*</td>
			</tr>
		</table>

		<br> <input type="submit" value="確認">
	</form>

	<a href="/emsys/InquiryServlet">戻る</a>
	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>