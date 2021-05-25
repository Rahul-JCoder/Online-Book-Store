package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.online.bean.ProfileDTO;
import com.online.delegate.ProfileMgrDelegate;
import com.online.util.UtilConstants;

public class RecoverpasswordAction extends HttpServlet {

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
		String password = null;
		try {
			ProfileDTO pf = new ProfileDTO();
			String loginname = request.getParameter("username");
			System.out.println("loginname is" + loginname);
			String squest = request.getParameter("squest");
			System.out.println("loginname is" + squest);
			String answer = request.getParameter("answer");
			System.out.println("loginname is" + answer);
			pf.setUsername(loginname);
			pf.setSquest(squest);
			pf.setSecrete(answer);
			password = new ProfileMgrDelegate().recoverPassword(pf);
			System.out.println("password is" + password);
			if (password.equals("") || password == null) {
				request.setAttribute(UtilConstants._STATUS,
						"Entries not Matched... Try Again");
				target = UtilConstants._RECOVER_PASSWORD;
			} else {
				request.setAttribute(UtilConstants._STATUS, "Password is  "
						+ password);
				target = UtilConstants._LOGIN;
			}
		} catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS,
					"Entries not Matched... Try Again");
			target = UtilConstants._RECOVER_PASSWORD;
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);

	}

}
