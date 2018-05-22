package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDetailDAO;
import com.niit.model.OrderDetail;

public class OrderUnitTest 
{
	static OrderDetailDAO orderDetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setCartId(102);
		orderDetail.setShippingAddr("Mumbai");
		orderDetail.setTotalAmount(1100);
		orderDetail.setUsername("swaraj");
		orderDetail.setTranType("CC");
		orderDetail.setOrderDate(new Date());
		
		assertTrue("Problem in Insertion of OrderDetail",orderDetailDAO.confirmOrderDetail(orderDetail));
	}
}
