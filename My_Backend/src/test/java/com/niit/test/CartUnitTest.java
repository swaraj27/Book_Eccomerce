package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartUnitTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		
		cartItem.setProductId(2);
		cartItem.setOrderId(101);
		cartItem.setQuantity(3);
		cartItem.setUsername("Suyash");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(852);
		
		assertTrue("Problem in Insertion",cartDAO.addCartItem(cartItem));
	}
}
