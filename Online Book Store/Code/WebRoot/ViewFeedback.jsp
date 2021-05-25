<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.online.db.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
  <jsp:include page="Header.jsp"></jsp:include>
  <jsp:include page="AdminMenu.jsp"></jsp:include>
  
  
  <%! Connection con=null; %>
  <%! Statement st=null;  %>
  <%! ResultSet rs=null;  %>
  
 
 <%
con =ConnectionFactory.getConnection();
st=con.createStatement();
rs=st.executeQuery("select * from editorials");
%>
<center>
<h3>Feedback Form</h3>
<TABLE BORDER="1">
				<TR>

					<TH>
						isbnid
					</TH>
					<TH>
						feedback
					</TH>
					
					
				</TR>
				<%
					while (rs.next()) {
				%>
				<TR>
					<TD>
						<%=rs.getString(1)%></td>
					<TD>
						<%=rs.getString(2)%></TD>
					
			
				</TR>
				<%
					}
				%>

</TABLE>
</center>
</body>
</html>
