package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO

{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean addCategory(Category category) 
	{	
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	//getCategory()
	public Category getCategory(int categoryId) 
	{
		Session session=(Session) sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		//session.close();
		return category;
	}
	public List<Category> getAllCategory()
	{
		
		Session session=(Session) sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
		
	}
	
	//deleteCategory()
	
	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
	
	//updateCategory()
	
	
	public boolean updateCategory(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	//listCategories()
	

}
