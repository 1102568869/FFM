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
<link rel="shortcut icon" type="image/x-icon" href="./public/img/0.png" />

<script type="text/javascript"
	src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js"
	charset="utf-8"></script>
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
	<br />尊敬的用户,
	<br />欢迎来到洗澡狂魔的技术阵地!
	<br /> 您的基本信息如下:
	<br />用户头像:
	<img alt="" src="${user.logo}">
	<br />
	<br />用户昵称:${user.nickname}
	<br />
	<button onclick="toLoginOut('${user.openid}')">退出登录</button>
	<br />
	<div class="bshare-custom">
		<a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博"
			class="bshare-sinaminiblog"></a><a title="分享到人人网"
			class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a
			title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台"
			class="bshare-more bshare-more-icon more-style-addthis"></a><span
			class="BSHARE_COUNT bshare-share-count">0</span>
	</div>
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/button.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script>
	<a class="bshareDiv" onclick="javascript:return false;"></a>
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/bshareC0.js"></script>
</body>
</html>
