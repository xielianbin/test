<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Register</title>
<style type="text/css">
body{
	background:url(source/images/register-bg.jpg);
}
.color{
	color:green;
}
*{
	color: white;
}
.box {
	width: 400px;
	height: 400px;
	margin: 30px auto;
	background: url(source/images/register-box-bg.jpg);
	padding-left: 60px;
	padding-top: 30px;
}

.describe {
	width: 60px;
	height: 50px;
	font-size: 14px;
}

.valueInput {
	width: 100px;
	height: 50px;
}

.explian {
	font-size: 13px;
	width: 200px;
	height: 50px;
	color: gainsboro;
	font-style: italic;
}

.buttonGroups {
	width: 300px;
	height: 50px;
	margin-top: 20px;
}

.resaveButton, .anewButton {
	width: 130px;
	height: 40px;
	color: forestgreen;
	font-size: 15px;
}

.resaveButton {
	float: left;
}

.anewButton {
	float: right;
}
</style>
</head>

<body>
	<div class="box">
		<form action="insertCustomerServlet" method="post">
			<div>
				<table>
					<!--输入用户名 -->
					<tr>
						<td class="describe">用户名:</td>
						<td class="valueInput"><input type="text" name="name" class="color" /></td>
						<td class="explian">请输入用户名</td>
					</tr>
					<!--输入密码 -->
					<tr>
						<td class="describe">密&nbsp;&nbsp;&nbsp;码:</td>
						<td class="valueInput"><input type="password" name="password"  class="color"/>
						</td>
						<td class="explian">请输入用户密码</td>
					</tr>
					<!--输入性别 -->
					<tr>
						<td class="describe">性&nbsp;&nbsp;&nbsp;别:</td>
						<td class="valueInput"><input type="text" name="sex"  class="color"/></td>
						<td class="explian">请输入用户性别</td>
					</tr>
					<!--输入常用地址 -->
					<tr>
						<td class="describe">地&nbsp;&nbsp;&nbsp;址:</td>
						<td class="valueInput"><input type="text" name="address" class="color" />
						</td>
						<td class="explian">请输入用户常用地址</td>
					</tr>
					<!--输入联系电话 -->
					<tr>
						<td class="describe">电&nbsp;&nbsp;&nbsp;话:</td>
						<td class="valueInput"><input type="text" name="telephone" class="color" />
						</td>
						<td class="explian">请输入用户的联系电话</td>
					</tr>
				</table>
			</div>
			<div class="buttonGroups">
				<div>
					<input type="submit" value="提交" class="resaveButton" />
				</div>
				<div>
					<input type="reset" value="重置" class="anewButton" />
				</div>
			</div>
		</form>
	</div>
</body>

</html>