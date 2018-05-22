package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



@Table(name="OrderDetail")
@Entity
public class OrderDetail 
{
	@Id
	@GeneratedValue
	int orderId;
	int cartId;
	
	String username;
	Date orderDate;
	int totalAmount;
	String shippingAddr;
	String tranType;
	String paymentStatus;
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCartId() 
	{
		return cartId;
	}
	public void setCartId(int cartId)
	{
		this.cartId = cartId;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public Date getOrderDate()
	{
		return orderDate;
	}
	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}
	public int getTotalAmount() 
	{
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) 
	{
		this.totalAmount = totalAmount;
	}
	public String getShippingAddr() 
	{
		return shippingAddr;
	}
	public void setShippingAddr(String shippingAddr)
	{
		this.shippingAddr = shippingAddr;
	}
	public String getTranType() 
	{
		return tranType;
	}
	public void setTranType(String tranType)
	{
		this.tranType = tranType;
	}

}
