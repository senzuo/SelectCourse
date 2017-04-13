package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class SelectCourseResult extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String sid;
	private List<CourseStudentBean> csbean;
	private List<CourseBean> cbean;
	

	public List<CourseStudentBean> getCsbean() {
		return csbean;
	}

	public void setCsbean(List<CourseStudentBean> csbean) {
		this.csbean = csbean;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public List<CourseBean> getCbean() {
		return cbean;
	}

	public void setCbean(List<CourseBean> cbean) {
		this.cbean = cbean;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		//查询条件
		String strWhere="1=1";
		strWhere+=" and sid= "+sid;//1=1 and sid=5 
		csbean = new CourseStudentDao().GetList(strWhere, "cid");//获取 course_student 表单
		cbean = new CourseDao().GetListByCSBean(csbean);
		
		System.out.println(cbean);
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}