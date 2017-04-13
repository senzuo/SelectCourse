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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加学生</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="StudentAddSave.action" onSubmit="return mycheck()" style="margin-bottom: 30px;">
              
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right" style="text-align: left;padding-left: 30px;
    padding-top: 15px;">&nbsp;逐个添加</td>
                    <td width="67%"><input name="Course_ID" type="text" class="noshow" id="Course_ID" ></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>学号：</td>
                    <td><input name="student_Num" type="text" class="text2" id="student_Num"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="student_Name" type="text" class="text2" id="student_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td align="left">
              	    	<select name="student_Gender" id="student_Gender">
              	    	<option value="男">男</option>
              	    	<option value="女">女</option>
              	    </select></td>
                  </tr>
                 
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="student_Pwd" type="text" class="text2" id="student_Pwd"></td>
                  </tr> 
                   
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>班级：</td>
                    <td align="left">
              	    <select name="student_Class" id="student_Class">
              	    <s:iterator value="list">
              	    	<option value="${cName}">${cName}</option>
              	    </s:iterator>
              	    </select></td>
                  </tr>                                                      
                 
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加学号">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form>
              
              <form name="form2" method="post" action="StudentBatchImport.action" onSubmit="return mycheck()" style="border-top: 1px solid #ccc;">
              
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right" style="text-align: left;padding-left: 30px;padding-top: 15px;">&nbsp;批量添加</td>
                    <td width="67%"><input name="Course_ID" type="text" class="noshow" id="Course_ID" ></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>网页链接：</td>
                    <td><input name="WebURL" type="text" class="text2" id="WebURL"></td>
                  </tr>
              
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="批量添加">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);">
                   </td>
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
