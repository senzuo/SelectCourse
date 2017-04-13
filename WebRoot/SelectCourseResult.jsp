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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">选课结果</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>教室</strong></td>
                    <td bgcolor="#D5E4F4"><strong>容量</strong></td>
                    <td bgcolor="#D5E4F4"><strong>座位号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>上课时间</strong></td>
                  </tr>
                  <s:iterator id="aa" value="cbean">
                    <tr align="center">
                      <td height="25" align="center">${Course_Name}</td>
                      <td>${Course_Address}</td>
                      <td>${Course_Capacity}</td>
                      <td>${Course_Capacity}</td>
                      <td>${Course_Start_Week}-${Course_End_Week}周  (周${Course_WeekDay}) ${Course_Start_Section}-${Course_End_Section}节</td>
                      <td align="center">
                        <a href="SelectCourseDel.action?cid=${Course_ID}&sid=<%=session.getAttribute("id").toString()%>" onClick="return confirm('确定要取消选择该课程吗？')">取消选择</a>
                       </td>
                    </tr>
                  </s:iterator>
                </table></td>
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
