package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.practice.entities.LoginData;

@Controller
public class MyController {
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "form";
	}

	@PostMapping("/submit")
	public String ProcessForm(@ModelAttribute("loginData") LoginData loginData) {
		return "success";
	}
}
