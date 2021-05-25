package com.online.serviceimpl;

import com.online.bean.SearchDTO;
import com.online.daoi.OrderDaoI;
import com.online.daoimpl.OrderDaoImpl;
import com.online.servicei.OrderServiceI;

public class OrderServiceImpl implements OrderServiceI{

	OrderDaoI daoI=new OrderDaoImpl();

	public boolean addCategoty(String category) {
		// TODO Auto-generated method stub
		return daoI.addCategoty(category);
	}

	public boolean addBookInfo(SearchDTO dto,String isbn) {
		// TODO Auto-generated method stub
		return daoI.addBookInfo(dto,isbn);
	}

	public boolean placeOrder(String userid, float total) {
		return daoI.placeOrder(userid, total);
	}

	public boolean deleteCartItem(int cartid) {
		return daoI.deleteCartItem(cartid);
	}

	public boolean acceptOrder(int orderid) {
		// TODO Auto-generated method stub
		return daoI.acceptOrder(orderid);
	}

	public boolean rejectOrder(int orderid) {
		// TODO Auto-generated method stub
		return daoI.rejectOrder(orderid);
	}
}
