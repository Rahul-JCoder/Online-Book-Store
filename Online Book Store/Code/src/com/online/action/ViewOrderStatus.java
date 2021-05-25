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

import com.online.bean.BookOrderDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class ViewOrderStatus extends HttpServlet {

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

		

		String target="";
		HttpSession session = request.getSession();
		String userid = session.getAttribute(UtilConstants._USERID).toString();
		int id = Integer.parseInt(userid);
		try{
			Vector<BookOrderDTO> dtos=new BookServiceMgrDelegate().viewOrderStatus(id);
			System.out.println(dtos.size());
			if(dtos.size()!=0)
			{
				request.setAttribute("dtos", dtos);
				target=UtilConstants._VIEW_STATUS;
			}
			else
			{
				request.setAttribute(UtilConstants._STATUS, "no records are found");
				target=UtilConstants._VIEW_STATUS;
			}
			
		}catch (NullPointerException e) {
			request.setAttribute(UtilConstants._STATUS, "no records are found");
			target=UtilConstants._VIEW_STATUS;
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}
		}


