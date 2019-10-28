<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserList画面</title>
<style type="text/css">

	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}

	table{
		text-align:center;
		margin:0 auto;
	}

	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}

	#header{
		width:100%;
		height:80px;
		background-color:black;
	}

	#main{
		width:100%;
		height:500px;
		text-align:center;
	}

	#left{
		float:left;
		width:300px;
		margin:30px 30px 30px 210px;
		padding:10px 0px;
		border:1px solid #333;
	}

	#right{
		float:left;
		width:300px;
		margin:30px auto;
		padding:10px 0px;
		border:1px solid #333;
	}

	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}

</style>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
			<h3>ユーザー情報は以下になります</h3>
			<table border="1">
				<tr>
					<th>個人番号</th>
					<th>ユーザー名</th>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>登録日時</th>
				</tr>
				<s:iterator value="userList">
				<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="userId"/></td>
						<td><s:property value="password"/></td>
						<td><s:property value="date"/></td>


				</tr>
					</s:iterator>
			</table>
			<s:form action="UserListDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>