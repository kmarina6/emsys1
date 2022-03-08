<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.DepartmentBean"%>
<%
ArrayList<DepartmentBean> depBeanList = (ArrayList<DepartmentBean>) request.getAttribute("depBeanList");
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
	<form action="/emsys/RegisterUser" method="post">

		<p>
			<font size="5">【登録】</font>
		</p>
		<p>◆入力フォームに入力してください</p>

		<table>
			<tr>
				<td align="right">社員番号：</td>
				<td><input type="text" pattern="[0-9]*" title="8桁の半角数字のみで入力して下さい。" name="emp_no" maxlength="8" required></td>
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
				<td align="right">Mail：</td>
				<td><input type="text" pattern="^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\.)+[a-zA-Z]{2,}$" title="メールアドレスは、aaa@example.comのような形で入力してください。" name="mail_add" required></td>
			</tr>
			<tr>
				<td align="right">登録者：</td>
				<td><input type="text" name="registered_person" required></td>
			</tr>
		</table>

		<br> <input type="submit" value="確認" onclick="checkDoubleSubmit()">
	</form>

	<a href="/emsys/top-jsp/top.jsp">TOP</a>
</body>
</html>