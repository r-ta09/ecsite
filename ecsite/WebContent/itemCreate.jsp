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
<title>ItemCreate画面</title>
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
			<p>ItemCreate</p>
		</div>

		<div>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage"/>
			</s:if>
			<s:form action="ItemCreateConfirmAction">
				<table>
					<tr>
						<td>
							<span>商品名：</span>
						</td>
						<td>
							<input type="text" name="itemName"/>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段：</span>
						</td>
						<td>
							<input type="text" name="itemPrice"/>　<span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>商品在庫：</span>
						</td>
						<td>
							<input type="text" name="itemStock"/>　<span>個</span>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="登録"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>