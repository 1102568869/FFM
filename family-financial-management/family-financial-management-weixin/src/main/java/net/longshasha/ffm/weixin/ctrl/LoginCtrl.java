package net.longshasha.ffm.weixin.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.longshasha.ffm.weixin.util.MemcachedHelper;

import org.nutz.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project family-financial-management-web
 * @classpath net.longshasha.ffm.web.ctrl.LoginCtrl
 * @author 陈雨清 2015年8月12日 下午7:28:05
 */
@Controller
@RequestMapping("/login")
public class LoginCtrl {
	@RequestMapping("/userlogin")
	public String userlogin() {
		System.out.println("----login/userlogin----");
		return "/loginsuccess";
	}

	@RequestMapping("/loginout")
	public void loginout(HttpServletResponse response, String openid) throws IOException {
		System.out.println("loginout  openid:" + openid);
		MemcachedHelper.newInstance().delete(openid);
		response.sendRedirect("http://www.longshasha.net/ffmweb/");
	}

	@RequestMapping("/ajaxlogin")
	@ResponseBody
	public String ajaxLogin(@RequestParam Map<String, String> map) {
		System.out.println("----login/ajaxlogin----");
		System.out.println(Json.toJson(map));
		MemcachedHelper.newInstance().set(map.get("openid"), map);
		return "success";
	}
}
