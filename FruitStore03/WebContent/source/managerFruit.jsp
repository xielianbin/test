<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<base href="<%=basePath%>">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Manager Fruit</title>
		<style type="text/css">
			td,
			th {
				text-aline: center;
				font-color: gray;
			}
			
			body {
				background: url(source/images/manager-bg.jpg);
			}
			
			.box {
				width: 600px;
				height: auto;
				color: white;
				margin-left: 50px;
				padding-left: 100px;
				margin-top: 50px;
				/*background: url(source/images/manager-box-bg.jpg);*/
			}
			.information-table{
				
				margin-left: 10px;
				padding-left: 50px;
			}
			.manager-table{
				
				margin-left: 10px;
				padding-left: 10px;
			}
			* {
				color: white;
				text-aline: center;
			}
			.yellow{
				color:green;
			}
		</style>
	</head>

	<body>
		<div class="box">
			<h1>${xinxi}</h1>
			<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${welcome}</h2>
			<div class="information-table">
				<table width="600" height="300" border="1" cellpadding="0">
					<tr>
						<th>ID</th>
						<th>水果名称</th>
						<th>水果单价</th>
						<th>水果单位</th>
					</tr>
					<c:forEach var="Fruit" items="${fruitList}">

						<tr>
							<td>&nbsp;&nbsp;&nbsp;${Fruit.id}</td>
							<td>&nbsp;&nbsp;&nbsp;${Fruit.name}</td>
							<td>&nbsp;&nbsp;&nbsp;${Fruit.price}</td>
							<td>&nbsp;&nbsp;&nbsp;${Fruit.unit}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="manager-table">
				<table>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>水果ID</td>
						<td>水果名称</td>
						<td>水果价格</td>
						<td>水果计价单位</td>
						<td></td>
					</tr>
					<form action="insertFruitServlet" method="post">
						<tr>
							<td>添加水果:</td>
							<td><input type="text" name="insertId" class="yellow" value="0"></input>
							</td>
							<td><input type="text" name="insertName" class="yellow" value="0"></input>
							</td>
							<td><input type="text" name="insertPrice" class="yellow" value="0" ></input>
							</td>
							<td><input type="text" name="insertUnit" class="yellow" value="0" ></input>
							</td>
							<td><input type="submit" value="添加"></td>
						</tr>
					</form>
					<form action="updateFruitServlet" method="post">
						<tr>
							<td>更新水果:</td>
							<td><input type="text" name="updateId" class="yellow" value="0" ></input>
							</td>
							<td><input type="text" name="updateName" class="yellow" value="0"></input>
							</td>
							<td><input type="text" name="updatePrice" class="yellow" value="0"></input>
							</td>
							<td><input type="text" name="updateUnit" class="yellow" value="0" ></input>
							</td>
							<td><input type="submit" value="更新"></td>
						</tr>
					</form>
					<form action="deleteFruitServlet" method="post">
						<tr>
							<td>删除水果:</td>
							<td><input type="text" name="deleteId" class="yellow" value="0" ></input>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td><input type="submit" value="删除"></td>
						</tr>
					</form>
				</table>
			</div>
		</div>
	</body>

</html>