<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>online book store</title>
<link href="css/book.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
  <div class="header">
    <div class="header_new">
        <div class="logo"><image src="bookstore/image.jpg"></div>
      <div class="title"></div>
      <div class="homebars">
        <div class="button"><a href="Home1.jsp">HOME</a></div>
        <div class="button"><a href="AboutUs.jsp">ABOUTUS</a></div>
        <div class="button"><a href="ContactUs.jsp">CONTACTUS</a></div>
     </div>
    </div> 
    <!-- end .header --></div>
    <div class=".clearfloat"></div>
  <div class="content">
  <div class="sidebar1">
    <div class="login_box">
 

<div id="gallery"><center><b><a href="gallery.html"><font color="white">GALLERY</font></a></b></center></div>
    <div id="Gallery_images"><image src="bookstore/book1.jpg"> <image src="bookstore/book4.jpg"></div>
  </div>  </div>
  <div class="text_content">
  
  <br/>
    <br/>
      <br/>
        <br/>
          <br/>
    <p>AbidsBanFactory<br/>
      road No:12<br/>
         Phno:9000099000<br>
       Email:onlinebookstore@gmail.com<br>
       Fax:11000728</div>
  <div class="sidebar2">
  
  <div class="searchdiv1">
    <label for="seachbar"></label>
    <form id="form2" name="form2" method="post" action="">
     
    </form>
<div class="but"></div>
  </div>
<div id="arrival"><a href="gallery.html">New Items Arrived</a><image src="bookstore/book3.jpg">  <image src="bookstore/book2.jpg"></div>
    <!-- end .content --></div>
</div>
  <div class="footer">
    <!-- end .footer -->&copy;copyrights2013</div>
<!-- end .container --></div>
</body>
</html>
