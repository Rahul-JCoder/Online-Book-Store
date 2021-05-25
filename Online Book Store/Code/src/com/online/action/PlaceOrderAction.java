package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class PlaceOrderAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String target="";
		boolean flag=false;
		try{
		float total=	Float.parseFloat(request.getParameter("total"));
			HttpSession httpSession=request.getSession();
		String userid=	httpSession.getAttribute(UtilConstants._USERID).toString();
		int id=Integer.parseInt(userid);
		flag= new BookServiceMgrDelegate().placeOrder(userid,total);
		if(flag)
		{
			request.setAttribute(UtilConstants._STATUS, "order placed sucessfully");
			target=UtilConstants._USER_HOME;
			
		}
		else
		{
			request.setAttribute(UtilConstants._STATUS, "order placed failed");
			target=UtilConstants._CART;
		}
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}

}
