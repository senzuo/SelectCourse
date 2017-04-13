package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class CourseAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Course_Name ;
    private String Course_Address ;
    private int Course_Capacity;
    private int Course_Start_Week;
    private int Course_End_Week;
    private int Course_WeekDay;
    private int Course_Start_Section;
    private int Course_End_Section;



	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getCourse_Address() {
		return Course_Address;
	}

	public void setCourse_Address(String course_Address) {
		Course_Address = course_Address;
	}

	public int getCourse_Capacity() {
		return Course_Capacity;
	}

	public void setCourse_Capacity(int course_Capacity) {
		Course_Capacity = course_Capacity;
	}

	public int getCourse_Start_Week() {
		return Course_Start_Week;
	}

	public void setCourse_Start_Week(int course_Start_Week) {
		Course_Start_Week = course_Start_Week;
	}

	public int getCourse_End_Week() {
		return Course_End_Week;
	}

	public void setCourse_End_Week(int course_End_Week) {
		Course_End_Week = course_End_Week;
	}

	public int getCourse_WeekDay() {
		return Course_WeekDay;
	}

	public void setCourse_WeekDay(int course_WeekDay) {
		Course_WeekDay = course_WeekDay;
	}

	public int getCourse_Start_Section() {
		return Course_Start_Section;
	}

	public void setCourse_Start_Section(int course_Start_Section) {
		Course_Start_Section = course_Start_Section;
	}

	public int getCourse_End_Section() {
		return Course_End_Section;
	}

	public void setCourse_End_Section(int course_End_Section) {
		Course_End_Section = course_End_Section;
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
		
		//查询名称是否存在
		List<CourseBean> list=new CourseDao().GetList("Course_Name='"+Course_Name+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('名称已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		CourseBean cnbean=new CourseBean();
		cnbean.setCourse_Address(Course_Address);
		cnbean.setCourse_Capacity(Course_Capacity);
		cnbean.setCourse_End_Section(Course_End_Section);
		cnbean.setCourse_End_Week(Course_End_Week);
		cnbean.setCourse_Name(Course_Name);
		cnbean.setCourse_Start_Section(Course_Start_Section);
		cnbean.setCourse_Start_Week(Course_Start_Week);
		cnbean.setCourse_WeekDay(Course_WeekDay);
		new CourseDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='CourseManager.action';</script>");
		out.flush();out.close();
		return null;
		
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
