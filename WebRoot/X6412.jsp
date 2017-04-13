<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>X6412选课界面</title>
	<link rel="stylesheet" href="./css/x6412.css">
	<script src="./js/xuanke.js"></script>
	<link rel="stylesheet" type="text/css" href="./js/bootstrap/css/bootstrap.min.css">
	<script src="./js/bootstrap/js/jquery-3.2.0.min.js"></script>
	<script src="./js/bootstrap/js/bootstrap.min.js"></script>
	

</head>

<body>
	<div class="container">
		<div class="row header">
			
			<div class="col-xs-10 col-sm-10 col-md-10 col-md-offset-1 col-xs-offset-1 col-sm-offset-1">
				<!-- <span class="HeadBar">X9126实验室</span> -->
				<ul class="tag">
					
    				<li class="HeadBar" id="not" style="padding-left: 8px;">X6412实验室</li>
				</ul>
			</div>
		</div>

		<div class="row bar">
		</div>

		<div class="row cont-out">
			<div class="col-xs-10 col-sm-10 col-md-10 col-md-offset-1 col-xs-offset-1 col-sm-offset-1" id="out-cont">

				<div class="row" style="margin-bottom: 15px">
					<div class="col-xs-6 col-sm-6 col-md-6 col-md-offset-3 col-xs-offset-3 col-sm-offset-3 text-center" id="X6421">
						X6412实验室座位图
					</div>
				</div>

				<div class="row cont-in" id="cont-h">
					<div class="col-xs-1 col-sm-1 col-md-1 text-center" id="cor-l">
						<span class="corridor">左<br><br>边<br><br>走<br><br>廊<br><br></span>
					</div>

					<div class="col-xs-10 col-sm-10 col-md-10 cont-left" id="h">
						<form action="" class="form-left">
							<div class="row">
								<div class="col-xs-5 col-sm-5 col-md-5 cont-left">
									<table class="table table-bordered" id="table-left">
									  <tbody>
									    <tr>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="19" value="option1"> 19号位
												</label>
									      </td>
									      <td class="td">
									      		<label>
													<input type="radio" name="optionsRadios" id="18" value="option1"> 18号位
												</label>
									      </td>
									    </tr>
									 	<tr>
									      <td class="td">
									      		<label>
													<input type="radio" name="optionsRadios" id="20" value="option1"> 20号位
												</label>
									      </td>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="17" value="option1"> 17号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="21" value="option1"> 21号位
												</label>
									      </td>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="16" value="option1"> 16号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="22" value="option1"> 22号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="15" value="option1"> 15号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="23" value="option1"> 23号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="14" value="option1"> 14号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="24" value="option1"> 24号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="13" value="option1"> 13号位
												</label>
									      </td>
									    </tr>
									  </tbody>
									</table>
								</div>

								<div class="col-xs-2 col-sm-2 col-md-2 cont-m">
									<span class="corridor">中<br><br>间<br><br>走<br><br>廊<br><br></span>
								</div>

								<div class="col-xs-5 col-sm-5 col-md-5 cont-left">
									<table class="table table-bordered" id="table-right" style="float: right;">
									 <tbody>
									 	<tr>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="7" value="option1"> 7号位
												</label>
									      </td>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="6" value="option1"> 6号位
												</label>
									      </td>
									    </tr>
									 	<tr>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="8" value="option1"> 8号位
												</label>
									      </td>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="5" value="option1"> 5号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="9" value="option1"> 9号位
												</label>
									      </td>
									      <td class="td">
												<label>
													<input type="radio" name="optionsRadios" id="4" value="option1"> 4号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="10" value="option1"> 10号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="3" value="option1"> 3号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="11" value="option1"> 11号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="2" value="option1"> 2号位
												</label>
									      </td>
									    </tr>
									    <tr>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="12" value="option1"> 12号位
												</label>
									      </td>
									      <td  class="td">
												<label>
													<input type="radio" name="optionsRadios" id="1" value="option1"> 1号位
												</label>
									      </td>
									    </tr>
									  </tbody>
									</table>
								</div>
							</div>
						</form>
					</div>

					<!-- <div class="col-xs-2 col-sm-2 col-md-2 text-center" id="cor-m">
						<span class="corridor">中<br><br>间<br><br>走<br><br>廊<br><br></span>
					</div> -->

					<!-- <div class="col-xs-4 col-sm-4 col-md-4 cont-right" id="r">
						<form action="" class="form-right">
							
						</form>
					</div> -->

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
									      <th class="text-center">班级</th>
									      <th class="text-center">座位</th>
									    </tr>
									  </thead>
									  <tbody>
									    <tr>
									    <s:iterator value="sbean">
									      <td  class="text-center">${student_Name} </td>
									      <td  class="text-center">${student_Num }</td>
									      <td  class="text-center">${student_Class}</td>
									      <td  class="text-center" id="zuowei">未选座</td>
									    </s:iterator>
									    </tr>
									  </tbody>
									</table>
								</form>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3">
							
							
								<form action="SelectCourseSeat.action" id="sub" autocomplete="on" method="get">
									我的选座：
									<input type="text" name="seatid" class="END" value="" style="width: 58%;">号座
									<s:iterator id="aa" value="csbean">
									<input name="cid" class="dis" style="display: none" value="${cid}">
									<input name="sid" class="dis" style="display: none" value="${sid}">
									</s:iterator>
									<input type="submit" id="Btn" style="width: 100px;margin-top: 5px;">
								</form>
							</div>
						</div>
					</div>
				</div>			
			</div>
		</div>
		<div class="row foot">
			<span>X6421实验室</span>
		</div>
	</div>
	
	
		<ul id = "ul">
		<s:iterator value = "cnbeanlist">
			<li>${seatid}</li>
		</s:iterator>
		</ul>
	
	
	
	<script type="text/javascript">
	
	window.onload=function(){	

		alert("注意:单击选座,双击取消选座,一人只能选择一个座位!");

		var flag = 0;

		var not = document.getElementById("not");
		not.style.cursor = "not-allowed";
		//限制选座函数
		function forbid(num) {
			var seat = document.getElementById(num);

			seat.parentNode.parentNode.className = "td s2";
			seat.parentNode.style.cursor = "not-allowed";
			seat.disabled = true;
		}

		function click(X){
			var seat = document.getElementById(X);

			var label = document.getElementsByTagName("label");
			for (var i = 0; i < label.length; i++) {
				if (label[i].parentNode.className != "td s2") {
					label[i].parentNode.className = "td";
				}
				
			}
			seat.parentNode.parentNode.className = "td s3";

		}


		var obj = document.getElementsByTagName("input");
		var checked = null;

		for (var i = 0; i < obj.length; i++){
			obj[i].onclick = function (e) {
	            e = e || window.event;
	            var el = e.srcElement;  
            	checked = el.id;
	            
	            if (!checked.checked == true) {
	            	click(checked);
	            	flag = 1;
	            }else{
	            	flag = 0;
	            }
	            document.getElementById("zuowei").innerHTML = checked+"号位";
	            document.getElementsByName("seatid")[0].value = checked;
			}
		}

		
		document.getElementById('Btn').onclick = function () {
	     				if(flag == 0){
	     					alert("您尚未选座！")
	     				}
	    				forbid(checked);
	            		alert("成功选择"+checked+"号位置!");
	            	}
		// alert(l.length);
		
		var myArray=new Array();
		var ul = document.getElementById("ul");
		var lis = ul.childNodes;
		
		//alert(lis[0].innerHTML);
		for(var i=1;i<lis.length;i+=2){
			forbid(lis[i].innerHTML);
		}
	}
	</script>

	
</body>
</html>