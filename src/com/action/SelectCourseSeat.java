package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class SelectCourseSeat extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String cid;
	private String sid;
	private String seatid;
	

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSeatid() {
		return seatid;
	}

	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
		
//		//��ѯ�����Ƿ����
//		List<CourseStudentBean> list=new CourseStudentDao().GetList("cid="+ cid + " sid="+sid , "");
//		if(list.size()>0)
//		{
//			out.print("<script language='javascript'>alert('�Ѿ����ڣ�');history.back(-1);</script>");
//			out.flush();out.close();return null;
//		}
		//�޸�
		CourseStudentBean cnbean=new CourseStudentBean();
		cnbean.setCid(Integer.parseInt(cid));
		cnbean.setSeatid(Integer.parseInt(seatid));
		cnbean.setSid(Integer.parseInt(sid));
		System.out.println(cnbean);
		new CourseStudentDao().Add(cnbean); 
		
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='CourseManager.action';</script>");
		out.flush();out.close();return null;
		
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
