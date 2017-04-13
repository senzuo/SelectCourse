<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>物联网工程专业选课系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Building_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">物联网工程专业选课系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加课程</td>
            </tr>
            <tr>
            
            <!-- 
              <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班级：</td>
                    <td align="left">
              	    <select name="student_Class" id="student_Class">
              	    	<option value="${cName}">${cName}</option>
              	    </select></td>
                  </tr>
             -->
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="CourseAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Course_ID" type="text" class="noshow" id="Course_ID" ></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>课程名称：</td>
                    <td><input name="Course_Name" type="text" class="text2" id="Course_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>教室：</td>
                    <td><input name="Course_Address" type="text" class="text2" id="Course_Address"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>容量：</td>
                    <td><input name="Course_Capacity" type="text" class="text2" id="Course_Capacity"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>开课周数：</td>
                    <td><input name="Course_Start_Week" type="text" class="text2" id="Course_Start_Week"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>结课周数：</td>
                    <td><input name="Course_End_Week" type="text" class="text2" id="Course_End_Week"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>上课周数：</td>
                    <td align="left">
              	    <select name="Course_WeekDay" id="Course_WeekDay">
              	    	<option value="1">周一</option>
              	    	<option value="2">周二</option>
              	    	<option value="3">周三</option>
              	    	<option value="4">周四</option>
              	    	<option value="5">周五</option>
              	    	<option value="6">周六</option>
              	    	<option value="7">周日</option>
              	    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>开课节数：</td>
                    <td><input name="Course_Start_Section" type="text" class="text2" id="Course_Start_Section"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>完课节数：</td>
                    <td><input name="Course_End_Section" type="text" class="text2" id="Course_End_Section"></td>
                  </tr>                                                      
                 
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加课程">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
