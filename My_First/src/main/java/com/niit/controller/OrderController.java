package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.sql.ordering.antlr.OrderByFragmentRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDetailDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;
import com.niit.model.Product;


@Controller
public class OrderController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	
	@RequestMapping(value="/ConfirmOrder")
	public String confirmOrder(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.getCartItems(username);
		m.addAttribute("cartList",listCartItems);
		m.addAttribute("grandTotal", this.grandTotal(listCartItems));
		
		
		return "Order";
	}
	
	@RequestMapping(value="/PaymentConfirm", method=RequestMethod.POST)
	public String paymentConfirm(@RequestParam("pmode")String pmode,@RequestParam("shipAddr")String shipAddr,HttpSession session,Model m)
	{
		
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.getCartItems(username);
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setCartId(listCartItems.get(0).getOrderId());
		orderDetail.setOrderDate(new Date());
		orderDetail.setTranType(pmode);
		orderDetail.setShippingAddr(shipAddr);
		orderDetail.setTotalAmount(this.grandTotal(listCartItems));
		orderDetail.setUsername(username);
		
		
		orderDetailDAO.confirmOrderDetail(orderDetail);

		
		for (CartItem cartItem : listCartItems) 
		{
			cartItem.setPaymentStatus("P");
			cartItem.setOrderId(orderDetail.getOrderId());
			cartDAO.updateCartItem(cartItem);
		}
		
		List<OrderDetail> orderDetail1=orderDetailDAO.getOrderDetail(username);
		m.addAttribute("orderList",orderDetail1);
		orderDetail.setPaymentStatus("P");
		orderDetailDAO.updateOrderDetail(orderDetail);
		return "ThankYou";
	}
	
	public int grandTotal(List<CartItem> listCartItems)
	{
		int grandTotal=0;
		for (CartItem cartItem : listCartItems)
		{
			Product product=productDAO.getProduct(cartItem.getProductId()); 
			grandTotal=grandTotal+(cartItem.getQuantity())*(product.getPrice());
			
		}
		return grandTotal;
	}
}
