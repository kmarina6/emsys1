<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.UserBean"%>
<%
ArrayList<UserBean> beanList = (ArrayList<UserBean>) request.getAttribute("beanList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="inquiry.js"></script>

<script>
	function multipleaction(u) {
		var f = document.querySelector("form");
		var a = f.setAttribute("action", u);
		document.querySelector("form").submit();
	}
</script>

<title>ユーザ表示</title>
</head>
<body>

	<a><font size="5">【社員 一覧】</font></a>
	<br>

	<table border="1" style="border-collapse: collapse">
		<tbody>
			<tr>

				<th>削除済</th>
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
				<th>編集</th>
				<th>削除</th>

			</tr>
			<%
			for (UserBean bean : beanList) {
			%>

			<tr>

				<td><%=bean.getDeleteFlag()%></td>
				<td><%=bean.getEmpNo()%></td>
				<td><%=bean.getEmpName()%></td>
				<td><%=bean.getEmpKana()%></td>
				<td><%=bean.getHireYmd().replaceAll("-", "/").replace("null", "")%></td>
				<td><%=bean.getRetirementYmd().replaceAll("-", "/").replace("null", "")%></td>
				<td><%=bean.getDepartmentData()%></td>
				<td><%=bean.getMailAdd()%></td>
				<td><%=bean.getUpdateDate().replaceAll("-", "/")%></td>
				<td><%=bean.getUpdatePerson()%></td>
				<td><%=bean.getRegisteredDate().replaceAll("-", "/")%></td>
				<td><%=bean.getRegisteredPerson()%></td>

				<td><input type="button" name="emp_no"
					onclick="location.href='http://localhost:8080/emsys/Search?action=update'"
					value="編集"></td>

				<td><input type="button" name="emp_no"
					onclick="location.href='http://localhost:8080/emsys/Search?action=delete'"
					value="削除"></td>
			</tr>
			<%
			} // endfor
			%>
		</tbody>
	</table>
	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>