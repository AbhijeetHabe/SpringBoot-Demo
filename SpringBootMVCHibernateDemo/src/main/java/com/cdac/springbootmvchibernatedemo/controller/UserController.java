package com.cdac.springbootmvchibernatedemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdac.springbootmvchibernatedemo.dao.UserDao;
import com.cdac.springbootmvchibernatedemo.pojo.User;

@Controller
public class UserController {

	@Autowired
	private UserDao daoImpl;
	
	@GetMapping("/")
	public String welcomePage(Model m) {
		m.addAttribute("userobj", new User());
		return "login";
	}
	
	@GetMapping("/reg") 
	public String registrationPage(Model m) {
		m.addAttribute("userobj", new User());
		return "register";
	}
	
	@PostMapping("/checkuser")
	public String check(@ModelAttribute("userobj") User user,
			HttpServletRequest request, Model m) {
		
		if (daoImpl.checkUserCedentials(user)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("USERNAME", user.getUsername());
			return "home";
		}
		else {
			m.addAttribute("MSG", "Invalid login credentials");
			m.addAttribute("MSGCOLOR", "red");
			return "login";
		}
	}
	
	@PostMapping("/reguser")
	public String register(@ModelAttribute("userobj") User user,
			Model m) {
		
		if (daoImpl.addNewUser(user)) {
			m.addAttribute("MSG", "Registration successful");
			m.addAttribute("MSGCOLOR", "green");
			return "login";
		}
		else {
			m.addAttribute("MSG", "registration failed");
			m.addAttribute("MSGCOLOR", "red");
			return "register";
		}
	}
}
