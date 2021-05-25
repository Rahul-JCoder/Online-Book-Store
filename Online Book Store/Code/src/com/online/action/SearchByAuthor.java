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
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class SearchByAuthor extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		String path = request.getParameter("path");
		String query = request.getParameter("query");
		String storepath = request.getRealPath("./path");
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute(UtilConstants._ROLE);
		try {
			Vector<SearchDTO> vector = new BookServiceMgrDelegate().searchByAuthor(query, storepath);
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
						UtilConstants._PROBLEM);
				target = path;
			}
		} catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS, UtilConstants._PROBLEM);
			target = path;
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
