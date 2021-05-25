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
		<base href="<%=basePath%>">

		<title>My JSP 'CustomerRegister.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/form_validation.js"
			type="text/javascript">

</script>
		<script type="text/javascript" src="js/myscripts.js">
</script>
		<script language="JavaScript" type="text/javascript"
			src="js/ts_picker.js">
			</script>
	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="HomeMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
		
		<form action="./CustomerRegisterAction" method="get" name="register">
	
		<table border="0" align="center">
				<th colspan="6" bgcolor="E2B147">
					Account Details
				</th>
				<tr>
					<td>

						User Name

					</td>
					<td width="303">
						<input type="text" name="username" 
						 	value=""/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						
					</td>
				</tr>
				<tr>
					<td>
						PassWord
					</td>
					<td>
						<input type="password" name="password"
							onkeyup="testPassword(document.forms.register.password.value);"
							onChange="Encrypt(document.forms.register.password.value);">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a id="Words"> Strength:</a>
					</td>
					<td>
						<table cellpadding=0 cellspacing=0>
							<tr>
								<td height=15 bgcolor=#dddddd></td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td>

						Confirm


					</td>
					<td>
						<input type="password" name="conformpassword" value="" size="20"
							onBlur="return validatePwd()" />
					</td>
				</tr>
				
					<tr>
					<td>

						SecurityQuestion

					</td>
					<td>
						<select name="squest">
							<option value="select" selected="true">
								<font size="3" face="Verdana">--Select One---</font>
							</option>
							<option value="What is your favorite pastime?">
								<font size="3" face="Verdana">What is your favorite
									pastime?</font>
							</option>
							<option value="Who your childhood hero?">
								<font size="3" face="Verdana">Who your childhood hero?</font>
							</option>
							<option value="What is the name of your first school?">
								<font size="3" face="Verdana">What is the name of your
									first school?</font>
							</option>
							<option value="Where did you meet your spouse?">
								<font size="3" face="Verdana">Where did you meet your
									spouse?</font>
							</option>
							<option value="What is your favorite sports team?">
								<font size="3" face="Verdana">What is your favorite
									sports team?</font>
							</option>
							<option value="What is your father middle name?">
								<font size="3" face="Verdana">What is your father middle
									name?</font>
							</option>
							<option value="What was your high school mascot?">
								<font size="3" face="Verdana">What was your high school
									mascot?</font>
							</option>
							<option value="What make was your first car or bike?">
								<font size="3" face="Verdana">What make was your first
									car or bike?</font>
							</option>
							<option value="What is your pet name?">
								<font size="3" face="Verdana">What is your pet name?</font>
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>

						Security Answer

					</td>
					<td>
						<input type="text" name="secrete" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td>

						UserType

					</td>
					<td>
						<input type="text" name="role" value="user" size="20" />
					</td>
				</tr>
				
				<tr></tr>
				<th colspan="6" bgcolor="E2B147">
					Personal Details
				</th>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>

						Full Name

					</td>
					<td width="276">
						<input type="text" name="fullname" value="">
					</td>
				</tr>
				
				<tr>
					<td>

						Birth Date

					</td>
					<td>
						<input type="text" name="dob" value="" size="20"
							readonly="readonly" />
						<a
							href="javascript:show_calendar('document.register.dob', document.register.dob.value);">
							<img src="./images/cal.gif" alt="a" width="18" height="18"
								border="0" /> </a>
					</td>
				</tr>
			<%-- 	<tr>
					<td>

						Browse Photo

					</td>
					<td>
						<img alt="See Photo Here" id="previewField" src="images/flag.gif"
							height="150" width="120">
						<input type="file" name="photo" class="textfield"
							onChange="preview(this)" />
				</tr> --%>
				<tr>
					<td>

						Gender

					</td>
					<td>
						<select name="gender">
							<option value="select" selected="true">
								<font size="3" face="Verdana">Select </font>
							</option>
							<option value="Male">
								<font size="3" face="Verdana">Male</font>
							</option>
							<option value="Female">
								<font size="3" face="Verdana">Female</font>
							</option>
						</select>
					</td>
				<tr>
					<td>

						Email

					</td>
					<td>
						<input type="text" name="email"  size="20" />
					</td>
				</tr>
				<tr>
					<td>

						Phone No

					</td>
					<td>
						<input type="text" name="phone" size="20" />
					</td>
				</tr>

<tr>
					<td>

						House No

					</td>
					<td>
						<input type="text" name="houseno"  size="20" />
					</td>
				</tr>
<tr>
					<td>

						Street

					</td>
					<td>
						<input type="text" name="street"  size="20" />
					</td>
				</tr>
				<tr>
					<td>

					City

					</td>
					<td>
						<input type="text" name="city"  size="20" />
					</td>
				</tr>
				
				<tr>
					<td>

						State

					</td>
					<td>
						<input type="text" name="state"  size="20" />
					</td>
				</tr>
				<tr>
					<td>

						Country

					</td>
					<td>
						<input type="text" name="country"  size="20" />
					</td>
				</tr>
				<tr>
					<td>

						Pin Number

					</td>
					<td>
						<input type="text" name="pin"  size="20" />
					</td>
				</tr>
				<tr>
					
					<td align="center">
						<font size="3" face="Verdana"> 
						<input type="submit" name="register" value="submit" />&nbsp; 
						<input type="reset" name="cancel" value="Cancel" /> </font>
					</td>
					<td align="center"></td>
				</tr>
			</table>
		
		
		</form>
		
		<br />
		

		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
    
  frmvalidator.addValidation("username","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
   frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("squest","dontselect=0");
   frmvalidator.addValidation("secrete","req","Please enter your Answer");
    
  
  frmvalidator.addValidation("fullname","req","Please enter your First Name");
  frmvalidator.addValidation("fullname","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("fullname","alpha"," First Name Alphabetic chars only");
  
 
  frmvalidator.addValidation("dob","req","Please enter your DOB"); 
   frmvalidator.addValidation("gender","dontselect=0");

frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   frmvalidator.addValidation("phone","req");
  frmvalidator.addValidation("phone","maxlen=10");
  frmvalidator.addValidation("phone","numeric");
 

 
 
 frmvalidator.addValidation("houseno","req","houseno required");
  
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   frmvalidator.addValidation("pin","numeric");
   </script>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>
