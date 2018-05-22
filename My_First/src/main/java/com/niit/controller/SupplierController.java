package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	 
	boolean flag=true;
	
	@RequestMapping("/Supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listSuppliers = supplierDAO.listSupplier();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Supplier supplier : listSuppliers) 
		{
			System.out.println(supplier.getSupName() + ",");
			System.out.println(supplier.getSupMob() + ",");

		}
		flag = false;
		return "Supplier";
	}
	
	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("supName") String supName, @RequestParam("supMob") String supMob,Model m)
	{
		Supplier supplier = new Supplier();
		supplier.setSupName(supName);
		supplier.setSupMob(supMob);
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers",listSuppliers);
		flag=false;
		return "Supplier";
	}
	
	@RequestMapping("/UpdateSupplier{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		List<Supplier> listSuppliers=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers",listSuppliers);
		m.addAttribute("supplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("supplierId") int supplierId,@RequestParam("supName") String supName,@RequestParam("supMob") String supMob,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupName(supName);
		supplier.setSupMob(supMob);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping("/DeleteSupplier{supplierId}")
	public String deleteCategory(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers",listSuppliers);
		flag=false;
		return "Supplier";
	}
	
}
