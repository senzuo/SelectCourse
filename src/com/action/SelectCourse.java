package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class SelectCourse extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String cid;
	private String sid;
	private List<CourseStudentBean> cnbeanlist;
	



	public List<CourseStudentBean> getCnbeanlist() {
		return cnbeanlist;
	}

	public void setCnbeanlist(List<CourseStudentBean> cnbeanlist) {
		this.cnbeanlist = cnbeanlist;
	}

	private CourseStudentBean csbean;
	private StudentBean sbean;
	


	public StudentBean getSbean() {
		return sbean;
	}

	public void setSbean(StudentBean sbean) {
		this.sbean = sbean;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public CourseStudentBean getCsbean() {
		return csbean;
	}

	public void setCsbean(CourseStudentBean csbean) {
		this.csbean = csbean;
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
		
		cnbeanlist = new CourseStudentDao().GetCourseListByCid(Integer.parseInt(cid));
		
		
		csbean = new CourseStudentBean();
		csbean.setCid(Integer.parseInt(cid));
		csbean.setSid(Integer.parseInt(sid));
		
		//通过course id 获取所有学生 id 到list中
		
		
//		csbean.setSeatid(Integer.parseInt(seatid));
		/************************/
		System.out.println(csbean);
		
		sbean = new StudentDao().GetBean(Integer.parseInt(sid));
//		System.out.println("***************"+sbean);
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