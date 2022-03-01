<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.UserBean"%>
<%
ArrayList<UserBean> beanList = (ArrayList<UserBean>) request.getAttribute("beanList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="inquiry.js"></script>
<title>ユーザ表示</title>
</head>
<body>
	<%!int count = 0;%>

	<a><font size="5">【社員 一覧】</font></a>
	<table border="1" style="border-collapse: collapse" cellspacing="1"
		cellpadding="4">
		<tbody>
			<tr>


				<th>社員番号</th>
				<th>社員名</th>
				<th>社員名かな</th>
				<th>入社日</th>
				<th>退職日</th>
				<th>所属部署</th>
				<th>メールアドレス</th>
				<th>更新日</th>
				<th>更新者</th>
				<th>作成日</th>
				<th>作成者</th>
				<th>削除</th>
				<th>編集</th>

			</tr>
			<%
				for (UserBean bean : beanList) {
				%>

			<tr>

				<td><%=bean.getEmpNo()%></td>
				<td><%=bean.getEmpName()%></td>
				<td><%=bean.getEmpKana()%></td>
				<td><%=bean.getHireYmd()%></td>
				<td><%=bean.getRetirementYmd()%></td>
				<td><%=bean.getDepartmentData()%></td>
				<td><%=bean.getMailAdd()%></td>
				<td><%=bean.getUpdateDate()%></td>
				<td><%=bean.getUpdatePerson()%></td>
				<td><%=bean.getRegisteredDate()%></td>
				<td><%=bean.getRegisteredPerson()%></td>

			</tr>

			<%
				count += 1;
				%>
			<%
				} // endfor
				%>
		</tbody>
	</table>
	<input type="hidden" name="emp_no" id=emp-no-id value="">
	</form>
	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>