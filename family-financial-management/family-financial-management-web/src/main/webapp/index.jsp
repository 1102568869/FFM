

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
<meta property="qc:admins" content="155654317764767301301665476657527" />
<title>My JSP 'index.jsp' starting page</title>
<link rel="shortcut icon" type="image/x-icon" href="public/img/0.png" />

<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101226591"
	data-redirecturi="http://www.longshasha.net/ffmweb/login/userlogin.ctrl" charset="utf-8"></script>
<!-- <script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101226591"
	data-redirecturi="http://longshasha.wicp.net/family-financial-management-web/login/userlogin.ctrl" charset="utf-8"></script>
 -->

<script type="text/javascript" src="public/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	//从页面收集OpenAPI必要的参数。get_user_info不需要输入参数，因此paras中没有参数
	var params = {};
	var user = {};
	//用JS SDK调用OpenAPI
	QC.api("get_user_info", params)
	//指定接口访问成功的接收函数，s为成功返回Response对象
	.success(function(s) {
		//alert("成功");
	})
	//指定接口访问失败的接收函数，f为失败返回Response对象
	.error(function(f) {
		//失败回调
		alert("失败");
	})
	//指定接口完成请求后的接收函数，c为完成请求返回Response对象
	.complete(function(c) {
		//alert("完成");
		user.nickname = c.data.nickname;
		user.logo = c.data.figureurl_qq_2;
		user.openid = params.openid;
		user.accessToken = params.access_token;
		console.info(user);
		//完成请求回调
		$.ajax({
			url : "login/ajaxlogin.ctrl",
			type : "POST",
			data : user,
			success : function(msg) {
				if (msg == "success") {
					location.href = "core/main.ctrl?openid=" + user.openid;
				}
			},
			error : function() {
			}
		})
	});
</script>
</head>
<body style="text-align: center;">
	<h2>please login!</h2>
	<form action="../login/userlogin.ctrl">
		<!--  -->
		帐号:<input type="text" name="username" /> <br />
		<!--  -->
		密码:<input type="password" name="userpwd" /><br /> <span id="qqLoginBtn"></span>
		<script type="text/javascript">
			QC.Login({
				btnId : "qqLoginBtn",//插入按钮的html标签id
				size : "A_M",//按钮尺寸
				scope : "all",//展示授权，全部可用授权可填 all
				display : "pc"//应用场景，可选
			});
		</script>
	</form>

</body>
</html>
