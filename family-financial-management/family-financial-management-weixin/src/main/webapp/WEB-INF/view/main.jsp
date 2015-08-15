<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>主页</title>
<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" charset="utf-8" ></script>
<script type="text/javascript" src="../public/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	if (!QC.Login.check()) {
		alert("用户已退出!");
		location.href = "login/loginout.ctrl";
	}
	function toLoginOut(openid) {
		if (confirm("是否确认退出?")) {
			QC.Login.signOut();
			location.href = "login/loginout.ctrl?openid=" + openid;
		}
	}
</script>
</head>
<body>
	<img alt="" src="./public/img/0.png" height="50px" width="50px"> 尊敬的用户,
	<br />欢迎来到洗澡狂魔的技术阵地!
	<br /> 您的基本信息如下:
	<br />用户头像:
	<img alt="" src="${user.logo}">
	<br />
	<br />用户昵称:${user.nickname}
	<br />
	<button onclick="toLoginOut('${user.openid}')">退出登录</button>
</body>
</html>
