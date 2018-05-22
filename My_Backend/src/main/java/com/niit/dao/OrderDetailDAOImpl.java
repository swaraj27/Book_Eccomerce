package com.niit.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO

{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean confirmOrderDetail(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	public List<OrderDetail> getOrderDetail(String username) 
	{
		
		try
		{
			Session session=sessionFactory.openSession();
			Query query=(Query) session.createQuery("from OrderDetail where username=:username and paymentStatus='NP'");
			query.setParameter("username", username);
			List<OrderDetail> orderDetail=query.getResultList();
			return orderDetail;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public boolean updateOrderDetail(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
