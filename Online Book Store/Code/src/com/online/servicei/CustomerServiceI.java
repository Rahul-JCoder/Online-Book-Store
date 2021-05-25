package com.online.servicei;

import java.util.Vector;

import com.online.bean.BookOrderDTO;

public interface CustomerServiceI {

	boolean addToCart(String isbn, float price, int id, BookOrderDTO dto);

	Vector<BookOrderDTO> viewCart(int id);

	Vector<BookOrderDTO> viewCustomerOrders(String s);

	Vector<BookOrderDTO> viewOrderStatus(int id);

	boolean post(String isbn, String opnion);

	Vector<BookOrderDTO> viewEditorials(String isbn);

}
