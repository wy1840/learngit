package cn.zaw.tsys.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/doTestUI")
	public String doTestUI() {
		return "test";
	}
}
