package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
		@RequestMapping(value={"/",""})
		public String m1()
		{
		return "Home";	
		}

		@RequestMapping(value="/Home")
		public String m2()
		{

			return "Home";
		}
		
		@RequestMapping(value="/Login")
		public String m3()
		{
		return "Login";	
		}
		
		
		@RequestMapping(value="/AboutUs")
		public String m5()
		{
		return "AboutUs";	
		}
		
		@RequestMapping(value="/ContactUs")
		public String m7()
		{
		return "ContactUs";	
		}
		
		
		@RequestMapping(value="/Logout")
		public String l1()
		{
		return "Home";	
		}
}

