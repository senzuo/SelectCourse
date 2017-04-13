<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>物联网工程专业选课系统</title>
    <base href="<%=basePath%>">
	<link rel="stylesheet" href="css/x6412.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="Style/Style.css" rel="stylesheet" type="text/css" />
	<script src="js/xuanke.js"></script>
</head>
<body>
	<div class="container">
		<div class="row header">
			<span>X6412实验室座位图</span>
		</div>
		<div class="row cont-out">
			<div class="col-xs-10 col-sm-10 col-md-10 col-md-offset-1 col-xs-offset-1 col-sm-offset-1" id="out-cont">

				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-md-offset-3 col-xs-offset-3 col-sm-offset-3 text-center" id="X6421">
						X6421实验室座位图
					</div>
				</div>

				<div class="row cont-in" id="cont-h">
					<div class="col-xs-1 col-sm-1 col-md-1 text-center" id="cor-l">
						<span class="corridor">左<br><br>边<br><br>走<br><br>廊<br><br></span>
					</div>

					<div class="col-xs-4 col-sm-4 col-md-4 cont-left" id="h">
						<form action="" class="form-left">
							<table class="table table-bordered">
							  <tbody>
							    <tr>
							      <td class="td">19号位</td>
							      <td class="td">18号位</td>
							    </tr>
							 	<tr>
							      <td class="td">20号位</td>
							      <td class="td">17号位</td>
							    </tr>
							    <tr>
							      <td class="td">21号位</td>
							      <td class="td">16号位</td>
							    </tr>
							    <tr>
							      <td  class="td">22号位</td>
							      <td  class="td">15号位</td>
							    </tr>
							    <tr>
							      <td  class="td">23号位</td>
							      <td  class="td">14号位</td>
							    </tr>
							    <tr>
							      <td  class="td">24号座</td>
							      <td  class="td">13号座</td>
							    </tr>
							  </tbody>
							</table>
						</form>
					</div>

					<div class="col-xs-2 col-sm-2 col-md-2 text-center" id="cor-m">
						<span class="corridor">中<br><br>间<br><br>走<br><br>廊<br><br></span>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4 cont-right" id="r">
						<form action="" class="form-right">
							<table class="table table-bordered">
							 <tbody>
							 	<tr>
							      <td class="td">7号位</td>
							      <td class="td">6号位</td>
							    </tr>
							 	<tr>
							      <td class="td">8号位</td>
							      <td class="td">5号位</td>
							    </tr>
							    <tr>
							      <td class="td">9号位</td>
							      <td class="td">4号位</td>
							    </tr>
							    <tr>
							      <td  class="td">10号位</td>
							      <td  class="td">3号位</td>
							    </tr>
							    <tr>
							      <td  class="td">11号位</td>
							      <td  class="td">2号位</td>
							    </tr>
							    <tr>
							      <td  class="td">12号座</td>
							      <td  class="td">1号座</td>
							    </tr>
							  </tbody>
							</table>
						</form>
					</div>

					<div class="col-xs-1 col-sm-1 col-md-1 text-center" id="cor-r">
						<span class="corridor">右<br><br>边<br><br>走<br><br>廊<br><br></span>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-10 col-md-offset-1 col-xs-offset-1 col-sm-offset-1">
						<div class="row" style="padding: 10px;">
							<div class="col-xs-4 col-sm-4 col-md-4">
								<span class="state s1"></span>
								可选的座位
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<span class="state s2"></span>
								已选的座位
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<span class="state s3"></span>
								您选的座位
							</div>
						</div>
					</div>
				</div>
					
				<div class="row" style="border-bottom: 2px dashed #666;">
					<div class="col-xs-1 col-sm-1 col-md-1"></div>
					<div class="col-xs-6 col-sm-6 col-md-6 text-center" id="platform">
						讲 台
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4 text-center" id="entrance">
						入口
					</div>
					<div class="col-xs-1 col-sm-1 col-md-1"></div>
				</div>

				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-10 col-md-offset-1 col-xs-offset-1 col-sm-offset-1">
						<div class="row">
							<div class="col-xs-9 col-sm-9 col-md-9">
								<form action="" id="peopleInfo">
									<table class="table table-hover">
									  <caption class="text-center">个人基本学籍信息</caption>
									  <thead>
									    <tr>
									      <th class="text-center">姓名</th>
									      <th class="text-center">学号</th>
									      <th class="text-center">学院</th>
									      <th class="text-center">班级</th>
									      <th class="text-center">座位</th>
									    </tr>
									  </thead>
									  <tbody>
									    <tr>
									    <s:iterator ></s:iterator>
									      <td  class="text-center">李栋</td>
									      <td  class="text-center">20132273</td>
									      <td  class="text-center">信息学院</td>
									      <td  class="text-center">物联14-01班</td>
									      <td  class="text-center" id="zuowei">未选座</td>
									    </tr>
									  </tbody>
									</table>
								</form>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3">
							<form id="sub" name="form1" method="post" action="SelectCourseSeat.action" onSubmit="return mycheck()" >
				                  <tr>
				                    <td height="30" align="right"><span style="color:red;">*</span>课程ID：</td>
				                    <td> <input name="cid" type="text" class="text2"  id="cid" value="<s:property value='csbean.cid'/>"></td>
				                  </tr>
				                  <tr>
				                    <td height="30" align="right"><span style="color:red;">*</span>学生ID</td>
				                    <td><input name="sid" type="text" class="text2" id="sid" value="<s:property value='csbean.sid'/>"></td>
				                  </tr>
				                  <tr>
				                    <td height="30" align="right"><span style="color:red;">*</span>座位号</td>
				                    <td><input name="seatid" type="text" class="text2" id="seatid" ></td>
				                  </tr>
				                  <tr>
				                    <td height="30">&nbsp;</td>
				                    <td><input type="submit" name="button" id="Btn" value="确认">
				                      &nbsp;&nbsp;
				                      <input type="button" name="button2" id="button2" value="返回" onClick="javascript:history.back(-1);"></td>
				                  </tr>
				                </form>
							</div>
						</div>
					</div>
				</div>			
			</div>
		</div>
		<div class="row foot">
			
		</div>
	</div>
</body>
</html>
