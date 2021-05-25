<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/eurotrans.dwt" codeOutsideHTMLIsLocked="false" -->

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<link href="styles/main.css" rel="stylesheet" type="text/css" />
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
if (emptyvalidation(username,"Please Enter An User Name")==false) {username.focus(); return false;};
if (emptyvalidation(squest,"Please Choose A Secret Question")==false) {squest.focus(); return false;};
if (emptyvalidation(answer,"Please Give An Answer To Your Secret Question")==false) {answer.focus(); return false;};
}
}
</script>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery.js">
</script>

<script type="text/javascript" src="scripts/my_menu.js">
</script>
</head>


<body>
  <jsp:include page="Header.jsp"></jsp:include>
   <jsp:include page="HomeMenu.jsp"></jsp:include><br/>
   <br/>
	
         <!-- InstanceBeginEditable name="content" -->

<br/>
<br/>
<br/>
         <jsp:include page="status.jsp"></jsp:include>
                <form action="./RecoverpasswordAction" method="post" name="register" onsubmit="return formvalidation(this)">
			
			<table border="0" align="center">
                      

			<h3><strong><font color="black">ForgotPassword Form </font></strong></h3></center>
			
		
				<tr>
					<td><span class=Title><font color="black"><b>Login Name</b></font></span></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><span class=Title><font color="black"><b>Secret Question</b></font></span></td>
					<td><span class=Title><select name="squest">
			      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
			      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
			      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
			      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
			      <option value="Where did you meet your spouse?"><font size="3" face="Verdana">Where did you meet your spouse?</font></option>
			      <option value="What is your favorite sports team?"><font size="3" face="Verdana">What is your favorite sports team?</font></option>
			      <option value="What is your father middle name?"><font size="3" face="Verdana">What is your father middle name?</font></option>
			      <option value="What was your high school mascot?"><font size="3" face="Verdana">What was your high school mascot?</font></option>
			      <option value="What make was your first car or bike?"><font size="3" face="Verdana">What make was your first car or bike?</font></option>
			      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option></select></span></TD>
				</TR>
				
				<TR>
					<TD><span class=Title><font color="black"><b>Secret Answer</b></font></span></TD>
					<TD><INPUT name="answer" type="text"/></TD>
				</TR>
				<TR><TD colspan="2"><span class=Title><DIV align="center">
						<INPUT name="Input" type="submit" value="Recover"/>&nbsp;
						<INPUT name="Input" type="reset" value="Clear"/>
				</DIV></span></TD></TR>
			</table>
						

		</TD>
						

	
						

			
						

	
						

	</TR>
						

</table>
</form>

<br/>
<br/>
<br/>
<jsp:include page="Footer.jsp"></jsp:include>



</body>
<!-- InstanceEnd --></html>
