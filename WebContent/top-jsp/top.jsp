<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員管理システムTOP</title>
</head>

<body>

<div style="text-align:center;">

<input type="button" onclick="location.href='http://localhost:8080/emsys/RegisterUser'"value="登録">
<br>
<input type="button" onclick="location.href='http://localhost:8080/emsys/InquiryServlet'"value="参照">
<br>
<input type="button" onclick="location.href='http://localhost:8080/emsys/Search?action=update'"value="編集">
<br>
<input type="button" onclick="location.href='http://localhost:8080/emsys/Search?action=delete'"value="削除">

</div>
</body>
</html>