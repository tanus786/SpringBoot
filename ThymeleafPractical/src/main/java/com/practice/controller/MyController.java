package com.practice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Going Inside About Handler");
		model.addAttribute("name", "Tanu Soni");
		model.addAttribute("date", new Date());
		return "about";
	}

	// Loop in Thymeleaf
	@GetMapping("/loop")
	public String iterateHandler(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Tanu");
		list.add("Updesh");
		list.add("Vanshika");
		list.add("Vaibhav");
		model.addAttribute("friends", list);
		return "iterate";
	}

	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("Conditional Handler Executed");
		m.addAttribute("isActive", false);
		m.addAttribute("gender", "M");
		List<Integer> list = List.of(1, 2, 3, 3);
		m.addAttribute("numbers", list);
		return "condition";
	}

	// Handler for Fragments
	@GetMapping("/fragment")
	public String fragmentHandler(Model m) {
		m.addAttribute("subtitle","It is fun game");
		m.addAttribute("title","I like to play badminton");
		return "fragment";
	}
}
