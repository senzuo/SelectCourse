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
   if(isNull(form1.Building_Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if (document.form1.Building_Password.value != document.form1.Building_Password2.value) { 
   alert("您两次输入的新密码不一致！请重新输入！"); 
   return false; 
   }  
   if(isNull(form1.Building_Name.value)){
   alert("请输入姓名！");
   return false;
   }
   if(isNull(form1.Building_Sex.value)){
   alert("请选择性别！");
   return false;
   }
   if(isNull(form1.Building_Tel.value)){
   alert("请输入联系电话！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改课程</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="CourseUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Course_ID" type="text" class="noshow" id="Course_ID" value="<s:property value='cnbean.Course_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>课程名称：</td>
                    <td><input name="Course_Name" type="text" class="text2" id="Course_Name" value="<s:property value='cnbean.Course_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>教室：</td>
                    <td><input name="Course_Address" type="text" class="text2" id="Course_Address" value="<s:property value='cnbean.Course_Address'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>容量</td>
                    <td><input name="Course_Capacity" type="text" class="text2" id="Course_Capacity" value="<s:property value='cnbean.Course_Capacity'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>开课周数</td>
                    <td><input name="Course_Start_Week" type="text" class="text2" id="Course_Start_Week" value="<s:property value='cnbean.Course_Start_Week'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>结课周数</td>
                    <td><input name="Course_End_Week" type="text" class="text2" id="Course_End_Week" value="<s:property value='cnbean.Course_End_Week'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>上课时间</td>
                    <td><input name="Course_WeekDay" type="text" class="text2" id="Course_WeekDay" value="<s:property value='cnbean.Course_WeekDay'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>开课节数</td>
                    <td><input name="Course_Start_Section" type="text" class="text2" id="Course_Start_Section" value="<s:property value='cnbean.Course_Start_Section'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>完课节数</td>
                    <td><input name="Course_End_Section" type="text" class="text2" id="Course_End_Section" value="<s:property value='cnbean.Course_End_Section'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="确认修改">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form>
              </td>
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
