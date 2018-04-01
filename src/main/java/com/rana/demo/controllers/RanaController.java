package com.rana.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rana")
public class RanaController {
 
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewRana()
	{
		return "view_rana" ;
	}
}
