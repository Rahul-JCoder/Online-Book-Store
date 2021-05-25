package com.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.bean.SearchDTO;
import com.online.db.ConnectionFactory;
import com.online.delegate.BookServiceMgrDelegate;
import com.online.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddBookInfoAction extends HttpServlet {

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
		boolean flag=false;
		Map map=request.getParameterMap();
		SearchDTO dto=new SearchDTO();
		String isbn1="";
		try {
			BeanUtils.populate(dto, map);
			Connection connection=ConnectionFactory.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select books_seq.nextval from dual");
		ResultSet resultSet=	preparedStatement.executeQuery();
		
			if(resultSet.next())
			{
			String	 isbn=resultSet.getString(1);
				 isbn1="isbn"+isbn;
				 System.out.println(isbn1);
			}
			
			flag=new BookServiceMgrDelegate().addBookInfo(dto,isbn1);
			if(flag)
			{
			request.setAttribute(UtilConstants._STATUS, "added sucessfully");	
			target=UtilConstants._ADMIN_HOME;	
			}
			else {
				request.setAttribute(UtilConstants._STATUS, "failed");	
				target=UtilConstants._ADD_BOOK_INFO;
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
