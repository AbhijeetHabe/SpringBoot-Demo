package com.springmvcdemo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcdemo3.dao.UserDao;
import com.springmvcdemo3.pojo.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDao daoImpl;
	
	@RequestMapping("/")
	public String welcomePage(Model m) {
		m.addAttribute("userobj", new User());
		return "login";
	}
	
	@RequestMapping(value = "/checkuser",
			method = RequestMethod.POST)
	public String check(@ModelAttribute("userobj") User user, ModelMap m) {
		
		if (daoImpl.checkUserCredentials(user))
		{
			return "home";
		}
		else {
			m.addAttribute("MESSAGE",
					"invalid login credentials");
			return "error";
		}
	}
}
