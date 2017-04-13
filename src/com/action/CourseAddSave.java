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

	//������Action�����ڷ�װ�û��������������
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

	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//��ѯ�����Ƿ����
		List<CourseBean> list=new CourseDao().GetList("Course_Name='"+Course_Name+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
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
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='CourseManager.action';</script>");
		out.flush();out.close();
		return null;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}
