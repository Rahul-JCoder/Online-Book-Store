package com.online.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.SearchDTO;
import com.online.daoimpl.OrderDaoImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UpdateBookSuccess extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SearchDTO cb = new SearchDTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(cb, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		String path = "";
		boolean flag = false;

		try {
			String isbn = request.getParameter("isbn");
           flag = new OrderDaoImpl().updateBranch(cb);
			System.out.println("in Action class vcb..........." + flag);
             if (flag) {
				request
						.setAttribute("status",
								" Course Updatation  is Success");
				path = "./Success.jsp";
			} else {
				request.setAttribute("status", "Updation of Course is Failed ");
				path = "./Success.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("status", "Invalid Data");
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
