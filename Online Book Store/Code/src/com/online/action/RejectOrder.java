package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class RejectOrder extends HttpServlet {

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

		String target = "";
		boolean flag = false;
		try {
			int orderid = Integer.parseInt(request.getParameter("id"));
			flag = new BookServiceMgrDelegate().rejectOrder(orderid);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						"customer order is rejected");
				target = UtilConstants._VIEW_ORDER;
			} else {
				request.setAttribute(UtilConstants._STATUS, "failed to reject");
				target = UtilConstants._VIEW_ORDER;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}


}
