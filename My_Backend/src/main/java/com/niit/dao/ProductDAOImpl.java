package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	
	public boolean addProduct(Product product) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	
	public Product getProduct(int productId)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		return product;
		
	}
	
	@Transactional
	public boolean deleteProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}	
	}

	@Transactional
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	
	public List<Product> listProducts() 
	{
		Session session=sessionFactory.openSession(); 
		Query query=session.createQuery("from Product");
		List<Product> Product=query.list();
		return Product;	
	}
}
