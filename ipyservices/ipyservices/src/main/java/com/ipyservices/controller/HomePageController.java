package com.ipyservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomePageController {
	@RequestMapping("/home1")
	public String Home()
	{
		return "this is home";
	}
}
