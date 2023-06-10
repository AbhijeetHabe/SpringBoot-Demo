package com.springmvcvalidationdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcvalidationdemo.dao.UserDao;
import com.springmvcvalidationdemo.pojo.User;

@Controller
public class LoginController {

	@Autowired
	private UserDao daoImpl;
	
	@RequestMapping("/")
	public String welcomePage(Model m) {
		m.addAttribute("userobj", new User());
		return "login";
	}
	
	@RequestMapping(value = "/checkuser" , method = RequestMethod.POST)
	public String check(@Valid @ModelAttribute("userobj") User user, BindingResult result,
			ModelMap m) {
		
		if(result.hasErrors())
			return "login";
			
		if(daoImpl.checkUserCredentials(user))
		{
			return "home";
		} 
		else {
			m.addAttribute("MESSAGE", "invalid login credentials");
			return "error";
		}
	}
}
