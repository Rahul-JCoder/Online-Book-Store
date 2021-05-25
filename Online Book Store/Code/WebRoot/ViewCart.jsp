<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ViewCart.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function calculate(form)
  {
  
  var total="00.00"; 
  var count=0;
     validate(form);
     for(var i=1;document.order.iprice[i]!=null;i++)
     { 
           if(document.order.quantity[i].value<=0)
            {
                alert("Quantity must be greater than Zero");
                document.order.quantity[i].value=1;
            }    
                document.order.price[i].value = (document.order.iprice[i].value)*(document.order.quantity[i].value);
                total=parseFloat(total)+parseFloat(document.order.price[i].value);
                document.order.total.value=total;
                
      }             
  }
function validate(form)
{
   for(var i=1;document.order.iprice[i]!=null;i++)
   {
       if(parseInt(document.order.quantity[i].value) > parseInt(document.order.iquantity[i].value))
       {
            alert("Not sufficient inventory");
            document.order.quantity[i].value = document.order.iquantity[i].value;
           //  calculate(form);
            return false;
       }   
   }
   return true;
}
</script>
<script type="text/javascript">
function emptyvalidation(entered, alertbox)
{

with (entered)
{
if (value==null || value=="")
{if (alertbox!="") {alert(alertbox);} return false;}
else {return true;}
}
} 

function formvalidation(thisform)
{
with (thisform)
{

if (emptyvalidation(total,"total amount should not empty")==false) {total.focus(); return false;};
}
}
</script>
	</head>

	<body >
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="UserMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
		<p align="center">
			<fieldset>
				<legend>
					<span class="style3">View Cart Items</span>
				</legend>

				<br />


				<form method="post" action="./PlaceOrderAction" name="order"
					onSubmit="return validate(order),formvalidation(this)">

					<table width="500" border="0" align="center" bordercolor="#8692E3">

						<tr bgcolor="#509C16">
							<td width="96">
								<div align="center" class="style8">
									Cartid
								
								</div>
							</td>
							
							<td width="96">
								<div align="center" class="style8">
									Book ISBN NO:
								
								</div>
							</td>
							<td width="62">
								<div class="style8">
									Inventory<input name="iquantity" type="hidden" value="0"/>
									
								</div>
							</td>
							<td width="98">
								<div class="style8">
									Price/Item<input name="iprice" type="hidden" value="0"/>
									
								</div>
							</td>
							<td width="61">
								<div class="style8">
									Quantity<input name="quantity" type="hidden" value="0"/>
									
								</div>
							</td>
							<td width="56">
								<div class="style8">
									Amount<input name="price" type="hidden" value="0"/>
									
								</div>
							</td>
							<td width="64">
								<div class="style8">
									Remove
								</div>
							</td>
						</tr>
						<c:if test="${not empty bookOrderDTOs}">
						<c:forEach var="bookOrderDTOs" items="${bookOrderDTOs}">
						<tr>
						
						<td width="96">
								<div align="center" class="style8">
									<input type="text" name="orderid" value="${bookOrderDTOs.orderid }" readonly="readonly">
								
								</div>
							</td>
							<td width="62">
								<div class="style8">
									<input type="text" name="isbn" value="${bookOrderDTOs.isbn }" readonly="readonly">
									
								</div>
							</td>
							<td width="62">
								<div class="style8">
									<input type="text" name="iquantity" value="${bookOrderDTOs.inventory }" readonly="readonly">
									
								</div>
							</td>
							<td width="98">
								<div class="style8">
								<input type="text" name="iprice" value="${bookOrderDTOs.price }" readonly="readonly">
									
								</div>
							</td>
							<td width="61">
								<div class="style8">
									<input type="text" name="quantity" value="${bookOrderDTOs.quantity }" onkeyup=" calculate(order)">
									
								</div>
							</td>
							<td width="56">
								<div class="style8">
									<input type="text" name="price" value="${bookOrderDTOs.price }">
									
								</div>
							</td>
							<td width="64">
								<div class="style8">
									<a href="./DeleteCartItemAction?cartid=${bookOrderDTOs.orderid}"><img src="images/delete_button.png" alt="" width="26" height="26"/></a>
								</div>
							</td>
						
						</tr>
						</c:forEach>
						</c:if>
						<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Total Amount</td>
						<td><input type="text" name="total" value=""/></td>
						</tr>
						<tr>
						<td>
						
						</td>
						<td></td>
						<td><input type="submit" name="submit" value="placeorder"/></td>
						<td><input type="reset" name="reset" value="back" onClick="javascript:history.back(-1)";/></td>
						</tr>
					</table>
				</form></fieldset>
	</body>
	<br/>
	<br/>
	<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>
