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
      
    </div> 
            <jsp:include page="HomeMenu.jsp"></jsp:include>
    <!-- end .header --></div>
    <div class=".clearfloat"></div>
  <div class="content">
  <div class="sidebar1">
    <div class="login_box">
 <marquee direction="right"><font color="orange" size="5">OnlineStore</font></marquee>

<div id="gallery"><center><b><a href="gallery.html"><font color="white">GALLERY</font></a></b></center></div>
    <div id="Gallery_images"><image src="bookstore/book1.jpg"> <image src="bookstore/book4.jpg"></div>
  </div>  </div>
  <div class="text_content">
  
  <br/>
    <br/>
      <br/>
        <br/>
          <br/>&nbsp; 
   
  <font color="red">BookProducts<br/></font>
          <br/>&nbsp; &nbsp;
         JavaBooks<br/>&nbsp;&nbsp; 
          Networks<br>&nbsp;&nbsp; 
      Oracle<br>&nbsp;&nbsp; 
       Spring<br/>&nbsp;&nbsp; 
       HibernateBooks<br/>
       
   <br/>&nbsp;&nbsp;&nbsp; 
   
           CloudComputingBook<br/>&nbsp;&nbsp;&nbsp; 
           CloudEnvironmentpart-I<br/>&nbsp;&nbsp;&nbsp; 
           Cloudenironmentart-II<br/>
            </div>
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
