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


import com.online.bean.ProfileDTO;
import com.online.delegate.ProfileMgrDelegate;
import com.online.util.UtilConstants;

public class ViewProfile extends HttpServlet {

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
		String path=request.getParameter("path");
		try {
			
			HttpSession session = request.getSession();
			String id = session.getAttribute("userid").toString();
			int id1 = Integer.parseInt(id);
			String role=session.getAttribute(UtilConstants._ROLE).toString();
		if(role.equalsIgnoreCase(UtilConstants._ADMIN))
		{
			
				Vector<ProfileDTO> profile = new ProfileMgrDelegate().viewUsers();
				System.out.println(profile.size());
				if (profile.size() != 0) {
					session.setAttribute("profile", profile);
					request.setAttribute(UtilConstants._STATUS, "Profile Details are ");
					target = path;
				} else {
					request.setAttribute(UtilConstants._STATUS, "no details are found");
					target = path;
				}
			}
			
		
		else
		{
			Vector<ProfileDTO> profile = new ProfileMgrDelegate().viewProfile(id1);
			System.out.println(profile.size());
			if (profile.size() != 0) {
				session.setAttribute("profile", profile);
				request.setAttribute(UtilConstants._STATUS, "Profile Details are ");
				target = path;
			} else {
				request.setAttribute(UtilConstants._STATUS, "no details are found");
				target = path;
			}
		}
			
		} catch (Exception e) {
			target = path;
			e.printStackTrace();
			throw new NullPointerException(UtilConstants._EXCEPTION);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		}
}
