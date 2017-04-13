package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class ShowCourseStudent extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Course_ID;
	private List<CourseStudentBean> cnbean;
	private List<StudentBean> sbean;

	public List<StudentBean> getSbean() {
		return sbean;
	}

	public void setSbean(List<StudentBean> sbean) {
		this.sbean = sbean;
	}

	public String getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}

	public List<CourseStudentBean> getCnbean() {
		return cnbean;
	}

	public void setCnbean(List<CourseStudentBean> cnbean) {
		this.cnbean = cnbean;
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
		//查询
		cnbean = new CourseStudentDao().GetCourseListByCid(Integer.parseInt(Course_ID));
		
		sbean = new StudentDao().GetListByCourse(cnbean);
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