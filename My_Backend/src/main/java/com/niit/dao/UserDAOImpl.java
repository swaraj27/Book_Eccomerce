package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserModel;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(UserModel user) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}

	public boolean deleteUser(UserModel user) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	
}
