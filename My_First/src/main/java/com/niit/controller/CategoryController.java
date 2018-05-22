package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;

	boolean flag = true;

	@RequestMapping("/Category")
	
	public String showCategory(Model m)
	{
		List<Category> listCategories = categoryDAO.getAllCategory();
		m.addAttribute("listCategories", listCategories);

		for (Category category : listCategories) 
		{
			System.out.println(category.getCategoryName() + ",");
			System.out.println(category.getCategoryDesc() + ",");

		}
		flag = false;
		return "Category";
	}
	
	@RequestMapping(value = "/InsertCategory", method = RequestMethod.POST)
	public String insertCategoryData(@RequestParam("catname") String catname, @RequestParam("catdesc") String catdesc,Model m)
	{
		Category category = new Category();
		category.setCategoryName(catname);
		category.setCategoryDesc(catdesc);

		categoryDAO.addCategory(category);

		List<Category> listCategories = categoryDAO.getAllCategory();
		m.addAttribute("listCategories", listCategories);
		flag = false;
		return "Category";
	}
	
	@RequestMapping("/updateCategory{categoryId}")
	public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		
		List<Category> listCategories=categoryDAO.getAllCategory();
		m.addAttribute("listCategories",listCategories);
		m.addAttribute("categoryInfo",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String categoryName,@RequestParam("catdesc") String categoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.getAllCategory();
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
	}
	
	@RequestMapping("/deleteCategory{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.getAllCategory();
		m.addAttribute("listCategories",listCategories);
		flag=false;
		return "Category";
	}
	
}
