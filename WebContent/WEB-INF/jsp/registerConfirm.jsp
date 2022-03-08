<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.User"%>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>

<!DOCTYPE html>
<html>
<head>
<script>
function checkDoubleSubmit(){
  var obj = document.getElementById("btnSubmit");
  if(obj.disabled){
    //ボタンがdisabledならsubmitしない
    return false;
  }else{
    //ボタンがdisabledでなければ、ボタンをdisabledにした上でsubmitする
    obj.disabled = true;
    return true;
  }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>

<body>
	<p>
		<font size="5">【登録】</font>
	</p>
	<p>下記のユーザーを登録します。</p>


	<table>
		<tr>
			<td align="right">社員番号：</td>
			<td><%=registerUser.getEmpNo()%></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td><%=registerUser.getEmpName()%></td>
		</tr>
		<tr>
			<td align="right">よみかな：</td>
			<td><%=registerUser.getEmpKana()%></td>
		</tr>
		<tr>
			<td align="right">入社日：</td>
			<td><%=registerUser.getHireYmd().replaceAll("-","/").replaceAll("null","")%></td>
		</tr>
		<tr>
			<td align="right">所属部署：</td>
			<td><%=registerUser.getDepartmentData().replaceAll("null","")%></td>
		</tr>
		<tr>
			<td align="right">Mail：</td>
			<td><%=registerUser.getMailAdd()%></td>
		</tr>
		<tr>
			<td align="right">登録者：</td>
			<td><%=registerUser.getRegisteredPerson()%></td>
		</tr>
	</table>

	<br>
	<input type="button" onclick="location.href='http://localhost:8080/emsys/RegisterUser?action=done';checkDoubleSubmit()"
		value="登録">

	<a href="/emsys/RegisterUser">戻る</a>
</body>
</html>