package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/home")
	@ResponseBody
	public String Home() {
		int a = 9;
		int b = 8;
		return "Hello There " + (a+b);
	}
}
