package com.online.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.BookOrderDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class ViewCustomerOrders extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";

		try {
			
			String s=request.getParameter("type");
			
			Vector<BookOrderDTO> dtos = new BookServiceMgrDelegate()
					.viewCustomerOrders(s);
			System.out.println(dtos.size());
			if (dtos.size() != 0) {
				request.setAttribute("dtos", dtos);
				if(s.equals("r"))
					target="ViewReports.jsp";
				else
					
				target = UtilConstants._VIEW_ORDER;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						"no orders are found");
				target = UtilConstants._VIEW_ORDER;
			}

		} catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS, "no orders are found");
			target = UtilConstants._VIEW_ORDER;
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}

}
