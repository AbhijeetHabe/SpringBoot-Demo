package com.springmvcdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcdemo2.dao.UserDao;
import com.springmvcdemo2.pojo.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDao daoImpl;
	
	@RequestMapping(value = "/checkuser",
			method = RequestMethod.POST)
	public String check(User user, Model m) {
		
		if (daoImpl.checkUserCredentials(user))
		{
			m.addAttribute("USERNAME", user.getUsername());
			return "home";
		}
		else {
			m.addAttribute("MESSAGE",
					"invalid login credentials");
			return "error";
		}
	}
}
