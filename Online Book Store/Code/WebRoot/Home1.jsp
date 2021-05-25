<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ONLINE BOOK SHOP</title>
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
        <div class="button"><a href="ContactUs.jsp">CONTACTUS</a></div>
        <div class="button"><a href="LoginForm.jsp">LOGIN</a></div>

      </div>
    </div> 
    <!-- end .header --></div>
    <div class=".clearfloat"></div>
  <div class="content">
  <div class="sidebar1">
    <div class="login_box">
  <form id="Login_ID" name="Login_Form" method="post" action="../event_Plan_Manage/LoginServlet">

  </form>
  </div>
<div id="gallery"><center><b><a href="gallery.html"><font color="white">GALLERY</font></a></b></center></div>
    <div id="Gallery_images"><image src="bookstore/book1.jpg"> <image src="bookstore/book4.jpg"></div>
  </div>
  <div class="text_content">
 
    <h2>The Design And Implementation of an online book store</h2>
    <p>Online shopping or online retailing is a form of electronic commerce which allows consumers to directly buy goods or services from a seller over the Internet using a web browser.<br/>
     Alternative names are: e-web-store, e-shop, e-store, Internet shop, web-shop, web-store, online store, and virtual store. An online shop evokes the physical analogy of buying products or services at a bricks-and-mortar retailer or shopping center; the process is called business-to-consumer (B2C) online shopping. In the case where a business buys from another business, the process is called business-to-business (B2B) online shopping. The largest of these online retailing corporations are eBay and Amazon.com, both based in the United States. Retail success is no longer all about physical stores, this is evident because of the increase in retailers now offering online store interfaces for consumers. With the growth of online shopping, comes a wealth of new market footprint coverage opportunities for stores that can appropriately cater to offshore market demands and service requirements.</p>
  </div>
  <div class="sidebar2">
  
  
  <div class="searchdiv1">
    <label for="seachbar"></label>
    <form id="form2" name="form2" method="post" action="">
      <label for="searchbar"></label>
     
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
 