package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.ProfileDTO;
import com.online.delegate.ProfileMgrDelegate;
import com.online.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class CustomerRegisterAction extends HttpServlet {

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
			throws ServletException, IOException

	{
		String target = "";
		boolean flag = false;
		try {
			ProfileDTO profileDTO = new ProfileDTO();
			Map map = request.getParameterMap();
			BeanUtils.populate(profileDTO, map);
			flag = new ProfileMgrDelegate().addCustomer(profileDTO);
			if (flag) 
			{
				request.setAttribute(UtilConstants._STATUS, "registration success");
				target=UtilConstants._LOGIN;

			} else 
			{
				request.setAttribute(UtilConstants._STATUS, "registration failed");
				target=UtilConstants._REGISTER;

			}

		} catch (Exception e) 
		{
			request.setAttribute(UtilConstants._STATUS, "registration failed");
			target=UtilConstants._REGISTER;
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);

	}

}
