package com.niit.dao;

import java.util.List;

import com.niit.model.OrderDetail;

public interface OrderDetailDAO 
{
	public boolean confirmOrderDetail(OrderDetail orderDetail);
	public List<OrderDetail> getOrderDetail(String username);
	public boolean updateOrderDetail(OrderDetail orderDetail);
	
}
