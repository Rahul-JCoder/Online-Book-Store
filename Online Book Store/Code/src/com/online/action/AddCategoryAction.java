package com.online.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class AddCategoryAction extends HttpServlet {

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
		boolean flag = false;
		try {
			String category = request.getParameter("category");
			flag = new BookServiceMgrDelegate().addCategoty(category);
			if (flag) {
				request.setAttribute(UtilConstants._STATUS,
						"category inserted sucessfully");
				target = UtilConstants._ADMIN_HOME;
			} else {

				request.setAttribute(UtilConstants._STATUS,
						"failed to insert a record");
				target = UtilConstants._ADD_CATEGORY;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(target);
		dispatcher.forward(request, response);

	}

}
