package com.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.db.ConnectionFactory;



public class InitServlet extends HttpServlet {

	public void init(ServletConfig sc) throws ServletException {
		ConnectionFactory dobject;

			ServletContext ctx = sc.getServletContext();
			InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
			Properties props = new Properties();
			
			try
			{
				props.load(fis);
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
			dobject = new ConnectionFactory();
			dobject.setProperties(props);

			LoggerManager.logger = new LoggerManager().getLogger(props.getProperty("logfile"));
			LoggerManager.writeLogInfo("Logger Instantiated");

			}

	}

