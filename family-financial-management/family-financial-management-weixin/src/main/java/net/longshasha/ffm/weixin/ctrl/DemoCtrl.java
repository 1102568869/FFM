package net.longshasha.ffm.weixin.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project family-financial-management-weixin
 * @classpath net.longshasha.ffm.weixin.ctrl.DemoCtrl
 * @author 陈雨清 2015年7月28日 下午9:20:02
 */
@Controller
@RequestMapping("/demo")
public class DemoCtrl {
	@RequestMapping("welcome")
	public String welcome() {
		System.out.println("welcome to ffm-wx");
		return "index";
	}
}
