package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.SearchDTO;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;

public class SearchCategoryAction extends HttpServlet {

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

		String tareget=null;
		String finalpath=request.getParameter("path");
		try{

			
 			String path=request.getRealPath("./path");
			Vector<SearchDTO> dtos=new BookServiceMgrDelegate().searchByCategory(path);
			if(dtos.size()!=0)
			{
			request.setAttribute("dtos", dtos);
			tareget=finalpath;
				
			}else
			{
				request.setAttribute(UtilConstants._STATUS, UtilConstants._NO_DATA);
				tareget=finalpath;
			}
			
		}catch (NullPointerException e) 
		{
			request.setAttribute(UtilConstants._STATUS, UtilConstants._NO_DATA);
			tareget=finalpath;
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(tareget);
		dispatcher.forward(request, response);
	}

}
