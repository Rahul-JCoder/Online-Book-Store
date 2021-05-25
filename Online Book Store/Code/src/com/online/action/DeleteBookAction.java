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
import com.online.daoimpl.BookDaoImpl;

public class DeleteBookAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		String path="";
		HttpSession session=request.getSession();
		String isbn=request.getParameter("isbn");
		System.out.println("isbn"+isbn);
		boolean flag=false;

		try
		{
			flag=new BookDaoImpl().deleteBook(isbn);
			
			System.out.println("flag value"+flag);
			if(flag){
				 request.setAttribute("status", "Book  deteletd  successfully");
				 path="./ViewBook.jsp";
			 }else{
				 request.setAttribute("status", "Book  deteletd  successfully");
				 path="./ViewBook.jsp";
			 }
		}catch (Exception e) {
			 request.setAttribute("status", "Category Detetion Failed plz try again");
			 path="./ViewBook.jsp";
		}
		rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
