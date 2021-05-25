<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Style 01 (Yellow Green) - Menu by Apycom.com</title>
    <link type="text/css" href="menu.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="menu.js"></script>
</head>
  
  <body bgcolor="pink">
  <style type="text/css">
* { margin:0;
    padding:0;
}
body {  }
div#menu { margin:5px auto; }
div#copyright {
    font:11px 'Trebuchet MS';
    color:;
    text-indent:30px;
    padding:40px 0 0 0;
}
div#copyright a { color:#9acd32; }
div#copyright a:hover { color:#fff; }
</style>

<div id="menu">
    <ul class="menu">
        <li><a href="Home1.jsp" class="parent"><span>Home</span></a>
                   </li>
        <li><a href="Product.jsp" class="parent"><span>Products</span></a>
        </li>
        <li><a href="Help.jsp"><span>Help</span></a></li>
        <li class="last"><a href="./LoginForm.jsp"><span>Login</span></a></li>
    </ul>
</div>

</body>
</html>