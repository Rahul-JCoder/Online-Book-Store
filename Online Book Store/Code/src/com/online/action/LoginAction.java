package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bean.ProfileDTO;
import com.online.delegate.ProfileMgrDelegate;
import com.online.exception.ConnectionException;
import com.online.util.UtilConstants;

public class LoginAction extends HttpServlet {

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

		String target = null;
		String role = null;
		int userid = 0;
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ProfileDTO p = new ProfileDTO();
			p.setUsername(username);
			p.setPassword(password);
			role = new ProfileMgrDelegate().checkUser(p);
			userid = p.getUserid();
			System.out.println("userid is====>" + userid);
			if (role.equalsIgnoreCase(UtilConstants._ADMIN)) {
				session.setAttribute(UtilConstants._USERID, userid);
				session.setAttribute(UtilConstants._UNAME, username);
				session.setAttribute(UtilConstants._ROLE, role);
				request.setAttribute("status", "Welcome to "
						+ session.getAttribute(UtilConstants._UNAME));
				target = UtilConstants._ADMIN_HOME;
			} else if (role.equalsIgnoreCase(UtilConstants._USER)) {

				session.setAttribute(UtilConstants._USERID, userid);
				session.setAttribute(UtilConstants._UNAME, username);
				session.setAttribute(UtilConstants._ROLE, role);

				request.setAttribute(UtilConstants._STATUS, "Welcome to "
						+ session.getAttribute(UtilConstants._UNAME));
				target = UtilConstants._USER_HOME;
			}

			else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._INVALID);
				target = UtilConstants._LOGIN;
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		try {
			target = UtilConstants._LOGIN;
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._EXCEPTION);
			throw new  ConnectionException(UtilConstants._CONNECTION_EXCEPTION);
			
		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}

		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

		}


