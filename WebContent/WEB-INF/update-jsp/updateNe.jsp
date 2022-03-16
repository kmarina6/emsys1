<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.SearchUser"%>
<%
SearchUser searchUser = (SearchUser) session.getAttribute("searchUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/submitButton.js"></script>
</head>
<body>

	<p>
		この社員番号は削除済みです。<br> 編集しますか？
	</p>
	<form method="POST">
		<input type="hidden" name="emp_no" value=<%=searchUser.getEmpNo()%>>
		<button type="submit" name="deleteUpdateFlag"
							formaction="http://localhost:8080/emsys/Search?action=update"
							value="true">編集する</button>
		<button type="button"
							onclick="location.href='http://localhost:8080/emsys/InquiryServlet'"
							>一覧に戻る</button>
	</form>

	<p><a href="/emsys/top-jsp/top.jsp">TOP</a></p>
</body>
</html>