<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/common/common.jsp"%>
<link rel="stylesheet"	href="<%=path %>/pages/css/login.css">
<title>欢迎来到万众主页</title>
</head>
<body class="login_bg">
<div class="container">
	<div class="row" style="margin-top:25%; ">
			<div class="col-md-5 col-xs-5">
    			<h1 style="color:#E6F5FF">万众主页欢迎您 !</h1>
			</div>
			<div class="core_pale col-md-7 col-xs-7">
				<form class="form-horizontal" role="form" action="<%=path %>/mainkind/to_main.do" method="post">
					&nbsp;
					<div class="form-group">
						<label for="firstname" class="col-xs-2 control-label">用户名</label>
						<div class="col-xs-10">
							<input name="user_id" type="text" class="form-control" id="firstname"
								placeholder="请输入用户名" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-xs-2 control-label">密码</label>
						<div class="col-xs-10">
							<input name="password" type="password" class="form-control" id="lastname"
								placeholder="请输入密码" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-2 col-xs-4">
							<div class="checkbox">
								<label> <input type="checkbox">请记住我
								</label>
							</div>
						</div>
						<div class="col-xs-6 col-md-6">
							<label style="color: red;margin: 5px;font-size: 14px">${returnMsg}</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="submit btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
	</div>
	<div class="row navbar-fixed-bottom" style="">
		<div style="text-align: center;color: white">
			<%@include file="register.jsp"%>
		</div>
	</div>
</div>
</body>
</html>