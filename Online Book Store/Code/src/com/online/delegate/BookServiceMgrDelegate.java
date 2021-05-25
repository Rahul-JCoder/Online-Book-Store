package com.online.delegate;

import java.util.Vector;

import com.online.bean.BookOrderDTO;
import com.online.bean.SearchDTO;
import com.online.servicei.CustomerServiceI;
import com.online.servicei.OrderServiceI;
import com.online.servicei.SearchServiceI;
import com.online.serviceimpl.CustomerServiceImpl;
import com.online.serviceimpl.OrderServiceImpl;
import com.online.serviceimpl.SearchServiceImpl;

public class BookServiceMgrDelegate {

	SearchServiceI serviceI=new SearchServiceImpl();
	CustomerServiceI  serviceI2=new CustomerServiceImpl();
	OrderServiceI serviceI3=new OrderServiceImpl();
	public Vector<SearchDTO> search(String query, String storepath) {
		// TODO Auto-generated method stub
		return serviceI.search(query,storepath);
	}
	public Vector<SearchDTO> searchByAuthor(String query, String storepath) {
		// TODO Auto-generated method stub
		return serviceI.searchByAuthor(query, storepath);
	}
	public Vector<SearchDTO> searchByCategory(String path) {
		// TODO Auto-generated method stub
		return serviceI.searchByCategory(path);
	}
	public Vector<SearchDTO> searchByCategory(int query, String storepath) {
		// TODO Auto-generated method stub
		return serviceI.searchByCategory(query, storepath);
	}
	public Vector<SearchDTO> searchByPrice(int query, int query1, String storepath) {
		// TODO Auto-generated method stub
		return serviceI.searchByPrice(query,query1, storepath);
	}
	public boolean addCategoty(String category) {
		// TODO Auto-generated method stub
		return serviceI3.addCategoty(category);
	}
	public boolean addBookInfo(SearchDTO dto, String isbn) {
		// TODO Auto-generated method stub
		return serviceI3.addBookInfo(dto,isbn);
	}
	public boolean addToCart(String isbn, float price, int id, BookOrderDTO dto) {
		// TODO Auto-generated method stub
		return serviceI2.addToCart(isbn, price, id,dto);
	}
	public Vector<BookOrderDTO> viewCart(int id) {
		// TODO Auto-generated method stub
		return serviceI2.viewCart(id);
	}
	public boolean placeOrder(String userid, float total) {
		// TODO Auto-generated method stub
		return serviceI3.placeOrder(userid, total);
	}
	public boolean deleteCartItem(int cartid) {
		// TODO Auto-generated method stub
		return serviceI3.deleteCartItem(cartid);
	}
	public Vector<BookOrderDTO> viewCustomerOrders(String s) {
		// TODO Auto-generated method stub
		return serviceI2.viewCustomerOrders(s);
	}
	public boolean acceptOrder(int orderid) {
		// TODO Auto-generated method stub
		return serviceI3.acceptOrder(orderid);
	}
	public boolean rejectOrder(int orderid) {
		// TODO Auto-generated method stub
		return serviceI3.rejectOrder(orderid);
	}
	public Vector<BookOrderDTO> viewOrderStatus(int id) {
		// TODO Auto-generated method stub
		return serviceI2.viewOrderStatus(id);
	}
	public boolean post(String isbn, String opnion) {
		// TODO Auto-generated method stub
		return serviceI2.post(isbn, opnion);
	}
	public Vector<BookOrderDTO> viewEditorials(String isbn) {
		// TODO Auto-generated method stub
		return serviceI2.viewEditorials(isbn);
	}
}
