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
import com.online.daoimpl.SecurityDaoImpl;
import com.online.util.UtilConstants;

public class ChangePasswordAction extends HttpServlet {

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
		try {
			HttpSession session = request.getSession();

			ProfileDTO rb = new ProfileDTO();
			boolean flag = false;
			rb.setPassword(request.getParameter("oldpassword"));
			rb.setUsername(request.getParameter("username"));
			rb.setNewpassword(request.getParameter("newpassword"));
			String role = request.getParameter("role");
			if (role.equalsIgnoreCase(UtilConstants._ADMIN)) {
				if ((request.getParameter(UtilConstants._OLDPASSWORD)
						.equals(request
								.getParameter(UtilConstants._NEWPASSWORD)))) {
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._P_EQUAL);
					target = UtilConstants._CHANGE_PASSWORD;
				} else {
					flag = new SecurityDaoImpl().changePassword(rb);

					if (flag) {
						request.setAttribute(UtilConstants._STATUS,
								UtilConstants._P_VALID);
						target = UtilConstants._ADMIN_HOME;
					}

					else {
						request
								.setAttribute(UtilConstants._STATUS,
										UtilConstants._P_INVALID);
						target = UtilConstants._CHANGE_PASSWORD;
					}
				}
			} else if (role.equalsIgnoreCase(UtilConstants._USER)) {
				if ((request.getParameter(UtilConstants._OLDPASSWORD)
						.equals(request
								.getParameter(UtilConstants._NEWPASSWORD)))) {
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._P_EQUAL);
					target = UtilConstants._CHANGE_PASSWORD;
				} else {
					flag = new SecurityDaoImpl().changePassword(rb);

					if (flag) {
						request.setAttribute(UtilConstants._STATUS,
								UtilConstants._P_VALID);
						target = UtilConstants._USER_HOME;
					} else {
						request
								.setAttribute("status",
										UtilConstants._P_INVALID);
						target = UtilConstants._CHANGE_PASSWORD;
					}
				}
			}
			
			else {
				request.setAttribute(UtilConstants._STATUS, UtilConstants._SESSION_INVALID);
				target = UtilConstants._LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		}
}
