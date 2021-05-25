package com.online.serviceimpl;

import java.util.Vector;

import com.online.bean.BookOrderDTO;
import com.online.daoi.CustomerDaoI;
import com.online.daoimpl.CustomerDaoImpl;
import com.online.servicei.CustomerServiceI;

public class CustomerServiceImpl implements CustomerServiceI {
	CustomerDaoI daoI = new CustomerDaoImpl();

	public boolean addToCart(String isbn, float price, int id, BookOrderDTO dto) {
		// TODO Auto-generated method stub
		return daoI.addToCart(isbn, price, id, dto);
	}

	public Vector<BookOrderDTO> viewCart(int id) {
		// TODO Auto-generated method stub
		return daoI.viewCart(id);
	}

	public Vector<BookOrderDTO> viewCustomerOrders(String s) {
		// TODO Auto-generated method stub
		return daoI.viewCustomerOrders(s);
	}

	public Vector<BookOrderDTO> viewOrderStatus(int id) {
		// TODO Auto-generated method stub
		return daoI.viewOrderStatus(id);
	}

	public boolean post(String isbn, String opnion) {
		// TODO Auto-generated method stub
		return daoI.post(isbn, opnion);
	}

	public Vector<BookOrderDTO> viewEditorials(String isbn) {
		// TODO Auto-generated method stub
		return daoI.viewEditorials(isbn);
	}

}
