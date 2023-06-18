package com.unla.Grupo16OO22023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo16OO22023.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("")
	public String index() {
		return ViewRouteHelper.INDEX;
	}

}
