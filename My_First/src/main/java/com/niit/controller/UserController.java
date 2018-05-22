package com.niit.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;
import com.niit.model.UserModel;

@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/UserHome")
	public String displayUserHome(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("listProducts",listProducts);
		
		return "UserHome";
		
	}
	
	@RequestMapping(value="/Register")
	public String m4(Model m)
	{
		UserModel userModel=new UserModel();
		m.addAttribute("userModel",userModel);
		return "Register";
	}
	
	@RequestMapping(value = "/InsertUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userModel")UserModel userModel,Model m)
	{	
		UserModel userModel1=new UserModel();
		m.addAttribute(userModel1);
		userModel.setEnabled(true);
		userModel.setRole("ROLE_USER");
		userDAO.addUser(userModel);
		return "Home";
	}
	
	@RequestMapping("/Login_success")
	public String showHomePage(HttpSession session,Model m)
	{
		String page="";
		boolean loggedIn=false;
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles= (Collection<GrantedAuthority>) authentication.getAuthorities();
		
		for (GrantedAuthority role : roles) 
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			
		}
		
		return page;
	}

	@RequestMapping("/login_error")
	public String showLoginPage(HttpSession session,Model m)
	{
		return "Error";
	}
}
