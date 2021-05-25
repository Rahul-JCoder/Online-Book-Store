package com.online.daoi;

import com.online.bean.SearchDTO;

public interface OrderDaoI {

	boolean addCategoty(String category);

	boolean addBookInfo(SearchDTO dto, String isbn);

	boolean placeOrder(String userid, float total);

	boolean deleteCartItem(int cartid);

	boolean acceptOrder(int orderid);

	boolean rejectOrder(int orderid);

}
