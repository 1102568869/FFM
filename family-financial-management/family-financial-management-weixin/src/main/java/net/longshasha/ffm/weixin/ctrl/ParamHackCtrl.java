package net.longshasha.ffm.weixin.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.longshasha.ffm.weixin.entity.AngularVo;

import org.nutz.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/param")
public class ParamHackCtrl {
	@RequestMapping("/test")
	@ResponseBody
	public List<AngularVo> testParam(@RequestParam Map map) {
		System.out.println("----map:" + Json.toJson(map));
		List<AngularVo> vos = new ArrayList<AngularVo>();
		AngularVo vo1 = new AngularVo();
		vo1.setUserName("zhangsan");
		vo1.setUserNick("张三丰");
		vo1.setUserPwd("122304");
		AngularVo vo2 = new AngularVo();
		vo2.setUserName("tianqi");
		vo2.setUserNick("田伯光");
		vo2.setUserPwd("322123");
		AngularVo vo3 = new AngularVo();
		vo3.setUserName("lisi");
		vo3.setUserNick("李四光");
		vo3.setUserPwd("221322");
		vos.add(vo1);
		vos.add(vo2);
		vos.add(vo3);
		return vos;
	}
}
