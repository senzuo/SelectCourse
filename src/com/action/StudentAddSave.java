package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class StudentAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
    private String student_Num ;
    private String student_Pwd ;
    private String student_Class;
    private String student_Name;
    private String student_Gender;


	public String getStudent_Num() {
		return student_Num;
	}

	public void setStudent_Num(String student_Num) {
		this.student_Num = student_Num;
	}

	public String getStudent_Pwd() {
		return student_Pwd;
	}

	public void setStudent_Pwd(String student_Pwd) {
		this.student_Pwd = student_Pwd;
	}

	public String getStudent_Class() {
		return student_Class;
	}

	public void setStudent_Class(String student_Class) {
		this.student_Class = student_Class;
	}

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public String getStudent_Gender() {
		return student_Gender;
	}

	public void setStudent_Gender(String student_Gender) {
		this.student_Gender = student_Gender;
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
		
		//添加
		StudentBean cnbean=new StudentBean();
		cnbean.setStudent_Class(student_Class);
		cnbean.setStudent_Gender(student_Gender);
		cnbean.setStudent_Name(student_Name);
		cnbean.setStudent_Num(student_Num);
		cnbean.setStudent_Pwd(student_Pwd);
		new StudentDao().Add(cnbean); 
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
		
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
