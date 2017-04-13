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

	//������Action�����ڷ�װ�û��������������
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
		
		cnbeanlist = new CourseStudentDao().GetCourseListByCid(Integer.parseInt(cid));
		
		
		csbean = new CourseStudentBean();
		csbean.setCid(Integer.parseInt(cid));
		csbean.setSid(Integer.parseInt(sid));
		
		//ͨ��course id ��ȡ����ѧ�� id ��list��
		
		
//		csbean.setSeatid(Integer.parseInt(seatid));
		/************************/
		System.out.println(csbean);
		
		sbean = new StudentDao().GetBean(Integer.parseInt(sid));
//		System.out.println("***************"+sbean);
		return SUCCESS;
		
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