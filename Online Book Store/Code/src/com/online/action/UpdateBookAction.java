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

public class UpdateBookAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doPost(request, response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
String path = "";
HttpSession session = request.getSession();
Vector<SearchDTO> opv = null;
System.out.println(opv);
String isbn=request.getParameter("isbn");
try {
	
	opv = new BookDaoImpl().viewBookInfo(isbn);
	System.out.println("objectdata"+opv);
if (!opv.isEmpty()) {
		request.setAttribute("bookinfo", opv);
    path = "./UpdateBook.jsp";
	} else if (opv.isEmpty()) {
		System.out.println("hhh");
		request.setAttribute("status", UtilConstants._NO_BOOK);
	  path ="./UpdateBook.jsp";
	} else {
		request.setAttribute("status", UtilConstants._NO_BOOK);
		  path ="./UpdateBook.jsp";
	}
} catch (Exception e) {

	request.setAttribute("status", UtilConstants._INVALIED_ENTRY);
	  path ="./UpdateBook.jsp";
}
RequestDispatcher rd = request.getRequestDispatcher(path);
rd.forward(request, response);
}
}
