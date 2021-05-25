package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bean.BookOrderDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class AddToCartAction extends HttpServlet {

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
		boolean flag = false;
		String target = "";
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		HttpSession session = request.getSession();
		String userid = session.getAttribute(UtilConstants._USERID).toString();
		int id = Integer.parseInt(userid);
		BookOrderDTO dto=new BookOrderDTO();
		try {
			flag = new BookServiceMgrDelegate().addToCart(isbn, price, id,dto);
			if (flag) {
				
				request.setAttribute(UtilConstants._STATUS, "item added to cart");
				int count= dto.getCount();
				request.setAttribute("count", count);
				target=UtilConstants._SEARCH_BY_TITLE;
				
			} else {

				request.setAttribute(UtilConstants._STATUS, "item added to cart is failed");
				target=UtilConstants._SEARCH_RESULTS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
