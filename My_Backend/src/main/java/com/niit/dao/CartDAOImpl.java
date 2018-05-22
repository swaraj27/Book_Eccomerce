package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;

@Repository
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addCartItem(CartItem cartItem) 
	{
		
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	@Transactional
	public boolean updateCartItem(CartItem cartItem) 
	{
		
		try
		{
		sessionFactory.getCurrentSession().update(cartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	@Transactional
	public boolean deleteCartItem(CartItem cartItem) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public CartItem getCartItem(int cartItemId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
			return cartItem;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<CartItem> getCartItems(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From CartItem where username=:username and paymentStatus='NP'");
			query.setParameter("username",username);
			List<CartItem> listCartItems=query.list();
			return listCartItems;
		}
		catch(Exception e)
		{
			return null;
		}
		
		
	}

}
