package com.online.servicei;

import com.online.bean.SearchDTO;

public interface OrderServiceI {

	boolean addCategoty(String category);

	boolean addBookInfo(SearchDTO dto, String isbn);

	boolean placeOrder(String userid, float total);

	boolean deleteCartItem(int cartid);

	boolean acceptOrder(int orderid);

	boolean rejectOrder(int orderid);

}
