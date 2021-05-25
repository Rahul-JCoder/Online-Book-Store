package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.BookOrderDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class ViewEditorials extends HttpServlet {

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
		String isbn=	request.getParameter("isbn");
		try {
			Vector<BookOrderDTO> eDtos = new BookServiceMgrDelegate()
					.viewEditorials(isbn);
			System.out.println(eDtos.size());
			if (eDtos.size() != 0) {
				request.setAttribute("eDtos", eDtos);
				target = UtilConstants._SEARCH_RESULTS_BY_USER;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						"no editorials are found");
				target = UtilConstants._SEARCH_RESULTS_BY_USER;
			}

		} catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS, "exception raised ,try again");
			target = UtilConstants._SEARCH_RESULTS_BY_USER;
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}


}
