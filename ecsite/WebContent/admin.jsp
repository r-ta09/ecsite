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
<title>管理者画面</title>
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
		margin:30px 30px 30px 430px;
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

	#under{
		clear:both;
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
			<p>管理者画面</p>
		</div>

		<div id="left">
			<h2>商品</h2>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit value="一覧"/>
				</s:form>
		</div>
		<div id="right">
			<h2>ユーザー</h2>
			<s:form action="UserCreateAction">
				<s:submit value="新規登録"/>
			</s:form>
			<s:form action="UserListAction">
				<s:submit value="一覧"/>
			</s:form>
		</div>

		<div id="under">
		<p><a href='<s:url action="GoHomeAction"/>'>HOME画面へ</a></p>
		</div>
	</div>

	<div id="footer">
	</div>
</body>
</html>