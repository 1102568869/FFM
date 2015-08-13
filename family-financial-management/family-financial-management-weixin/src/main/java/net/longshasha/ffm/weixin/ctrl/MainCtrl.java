package net.longshasha.ffm.weixin.ctrl;

import net.longshasha.ffm.weixin.util.MemcachedHelper;

import org.nutz.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @project family-financial-management-web
 * @classpath net.longshasha.ffm.web.ctrl.MainCtrl
 * @author 陈雨清 2015年8月12日 下午7:48:22
 */
@Controller
@RequestMapping("/core")
public class MainCtrl {
	@RequestMapping("/main")
	public ModelAndView toMain(ModelAndView mav, String openid) {
			
		Object userInfo = MemcachedHelper.newInstance().get(openid);
		System.out.println(Json.toJson(userInfo));
		mav.addObject("user", userInfo);
		System.err.println("---- toMain ----");
		mav.setViewName("/main");
		return mav;
	}

}
