package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier 
{
	@Id
	@GeneratedValue
	private int supplierId;
	private String supName;
	private String supMob;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	
	
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupMob() {
		return supMob;
	}
	public void setSupMob(String supMob) {
		this.supMob = supMob;
	}

}
