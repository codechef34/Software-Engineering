



<html>
<head>

<style type="text/css">

.formbutton{
cursor:hand;
border:outset 4px #ccc;
background:#999;
color:#666;
font-weight:bold;
width:90;
height:36;
padding: 1px 2px;
background:url(file:///D|/IBM%20Lappy/my%20documents/vamsi_administrator/My%20Documents/Vamsi/Projects_College/College_Feedback_System/image%5Csubmit.jpg) fixed;
}
</style>
<title>Add_Dept</title>
</head>
<body bgcolor="#E7EEF5">
<form action="file:///D|/IBM Lappy/my documents/vamsi_administrator/My Documents/Vamsi/Projects_College/College_Feedback_System/InsertIntoDepartment" insertIntoDepartment.jsp" method="post" name="add_dep2">
 


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="43%" bgcolor="#FFFFFF"><img src="file:///D|/IBM Lappy/my documents/vamsi_administrator/My Documents/Vamsi/Projects_College/College_Feedback_System/image/Title1.gif" width="376" height="78"></td>
    <td colspan="2" bgcolor="#006699"><div align="center"><font color="#FFFFFF" size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>Online Student Feedback System</strong></font></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td width="24%">&nbsp;</td>
    <td width="33%">&nbsp;</td>
  </tr>
</table>
<table border="1" bordercolor="#3399FF" cellpadding="0" cellspacing="0" bgcolor="#DFDFFF" width="100%">
<tr>
<td><div align="left"><a href="file:///D|/IBM Lappy/my documents/vamsi_administrator/My Documents/Vamsi/Projects_College/College_Feedback_System/admin.jsp"><img src="file:///D|/IBM Lappy/my documents/vamsi_administrator/My Documents/Vamsi/Projects_College/College_Feedback_System/gifs\ani-back.gif" width="110" height="42"></a></div></td>
</tr>
</table>
  <table width="100%" height="475" border="8" bordercolor="#006699" cellpadding="0" cellspacing="0">
  <tr>
    <td width="22%">&nbsp;</td>
    <td colspan="2"><center><B><font size="+3" color="#006699">-----------:Add Dept.:----------- </font></B></center></td>
     <td width="23%">&nbsp;</td>
  </tr>
  <tr>
    <td width="22%" height="36">&nbsp;</td>
    <td colspan="2" width="55%"><center><B><font size="+3" color="#006699">&nbsp; </font></B></center></td>
     <td width="22%">&nbsp;</td>
  </tr>

  <tr>
    <th width="22%" height="55">&nbsp;</th>
    <td width="29%"><center><B><font color="red" size="+2">*</font> <font size="+2" color="#006699">DEPARTMENT CODE</font></B></center></td>
    <td width="26%"><center><input type="text"  width "31%" border="2" name="dep_code1" id="dep_code1"></center></td>
    <td width="23%"><font color="red">department code should not contain  any special character.</font></td>
  </tr>
  <tr>
    <td width="22%" height="53">&nbsp;</td>
    <td width="29%"><center><B><font color="red" size="+2">*</font> <font size="+2" color="#006699">DEPARTMENT NAME</font></B></center></td>
   <td width="26%"><center><input type="text"  width "31%" border="2" name="dep_name1" id="dep_name1"></center></td>
    <td width="23%"><font color="red">dept name should not contain  any special character.</font></td>
  </tr>
  <tr>
    <th width="22%" height="53">&nbsp;</th>
    <td width="29%"><center><B><font size="+2" color="#006699">HEAD OF DEPARTMENT</font></B></center></td>
   <td width="26%"><center><input type="text"  width "31%" border="2" name="dep_hod1" id="dep_hod1"></center></td>
    <td width="23%"><font color="red">HOD should not contain  any special character.</font></td>
  </tr>
  <tr>
    <th width="22%" height="53">&nbsp;</th>
    <td width="29%"><center><B><font color="red" size="+2">*</font> <font size="+2" color="#006699">COURSE</font></B></center></td>
 <td width="26%"><center><input type="text"  width "31%" border="2" name="dep_course1"></center></td>
    <td width="23%"><font color="red">course should not contain  any special character except dot['.']and dash['-'].</font></td>
  </tr>
  <tr>
    <td width="22%">&nbsp;</td>
    <td colspan="2">
	<center>
	<input name="" type="submit"  value="SUBMIT" >
	</center>
	</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="100%" height="32" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#006699"><div align="center"><font color="#FFFFFF" size="1" face="Verdana, Arial, Helvetica, sans-serif">Copyright © 2010, Prasad V Potluri Siddhartha Institute of Technology, Designed and Hosted by PVPSIT<BR>
  Best viewed at 1024 x 768 resolution with Internet Explorer 5.0 or Netscape Navigator
  5.0 and higher</font></div></td>
  </tr>
</table>
<p>&nbsp;</p>


</form>

</body>
</html>




<%
}
else
    {
%>
<html>
        <body>
            <script>
                alert("You have no sufficient permission to see the page!");
                location.href="Admin_Login.jsp";
            </script>

            alert
        </body>
    </html>
    <%}%>