<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>Style 01 (Orange Red) - Menu by Apycom.com</title>
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
    color:#fff;
    text-indent:30px;
    padding:40px 0 0 0;
}
div#copyright a { color:#ff4500; }
div#copyright a:hover { color:#fff; }
</style>

<div id="menu">
    <ul class="menu">
     <li><a href="UserHome.jsp"><span>Home</span></a></li>
        <li><a href="UserHome.jsp" class="parent"><span>Search</span></a>
            <ul>
                <li><a href="SearchByTitle.jsp" ><span>SearchByTitle</span></a>
                   
                        </li>
                          <li><a href="SearchCategoryAction?path=./SearchByCategory.jsp" ><span>SearchByCategory</span></a>
                   
                        </li>
                          <li><a href="SearchByPrice.jsp" ><span>SearchByPrice</span></a>
                   
                        </li>
                          <li><a href="SearchByAuthor.jsp" ><span>SearchByAuthor</span></a>
                   
                        </li>
                    </ul>
         </li>
         <li><a href="./BookGalleryAction"><span>BooksGallery</span></a></li>
        <li><a href="UserHome.jsp" class="parent"><span>Shopping Cart</span></a>
            <ul>
               <li><a href="./ViewCartDetails" ><span>View Cart Details</span></a></li>
               <li><a href="./ViewOrderStatus" ><span>View Order Status</span></a></li>
            </ul>
        </li>
         <li><a href="SearchCategoryAction?path=./ViewCategories1.jsp" ><span>ViewBooksCategory</span>
							</a></li>
							     <li><a href="./ViewProfile?path=/ViewProfile.jsp"><span>View Profile</span></a></li>
        <li><a href="changepassword.jsp"><span>ChangePassword</span></a></li>
        <li class="last"><a href="./LogoutAction"><span>Logout</span></a></li>
    </ul>
</div>


</body>
</html>