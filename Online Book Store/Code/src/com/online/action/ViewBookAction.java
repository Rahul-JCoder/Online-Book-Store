package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bean.SearchDTO;
import com.online.daoimpl.BookDaoImpl;
import com.online.util.UtilConstants;

public class ViewBookAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doPost(request, response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
String path = "";
HttpSession session = request.getSession();
Vector<SearchDTO> opv = null;
String path1=request.getRealPath("/books_images");
try {
	opv = new BookDaoImpl().viewBooks(path1);
	System.out.println("jjjjjjjjjjjjjjjj"+opv);
if (!opv.isEmpty()) {
		request.setAttribute("bookinfo", opv);
      path = UtilConstants._VIEW_BOOKS1;
	} else if (opv.isEmpty()) {
		System.out.println("hhh");
		request.setAttribute("status", UtilConstants._NO_BOOK);
	  path = UtilConstants._VIEW_ALL_BOOKS1;
	} else {
		request.setAttribute("status", UtilConstants._NO_BOOK);
      path = UtilConstants._VIEW_ALL_BOOKS1;
	}
} catch (Exception e) {

	request.setAttribute("status", UtilConstants._INVALIED_ENTRY);
	path = UtilConstants._VIEW_ALL_BOOKS1;
}
RequestDispatcher rd = request.getRequestDispatcher(path);
rd.forward(request, response);
}
}
