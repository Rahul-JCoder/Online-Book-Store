package com.online.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bean.SearchDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class SearchAction extends HttpServlet {

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
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		String path = request.getParameter("path");
		String query = request.getParameter("query");
		String storepath = request.getRealPath("./path");
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute(UtilConstants._ROLE);
		try {
			Vector<SearchDTO> vector = new BookServiceMgrDelegate().search(
					query, storepath);
			System.out.println("size is" + vector.size());
			if (vector.size() != 0) {
				session.setAttribute("bookinfo", vector);
				if (role.equalsIgnoreCase("user")) {
					target = UtilConstants._SEARCH_RESULTS_BY_USER;
				} else {
					target = UtilConstants._SEARCH_RESULTS;
				}

			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._NO_DATA);
				target = path;
			}
		} catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS, UtilConstants._NO_DATA);
			target = path;
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
