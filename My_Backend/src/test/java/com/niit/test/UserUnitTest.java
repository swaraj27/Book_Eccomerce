package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserDAO;
import com.niit.model.UserModel;

public class UserUnitTest 
{
	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void addUserTest()
	{
		UserModel user=new UserModel();
		user.setUsername("Raj");
		user.setCustname("Ram");
		user.setCustmail("ram@gmail.com");
		user.setCustaddress("Mumbai,Jogeshwari");
		user.setCustmob("3698521478");
		assertTrue("Problem in Product Insertion",userDAO.addUser(user));
	}
}
