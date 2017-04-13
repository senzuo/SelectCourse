package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class ClassAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private int cid;
	private String cName;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
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
		List<ClassBean> list=new ClassDao().GetList("cName='"+ cName+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}		
		
		//���
		ClassBean cnbean=new ClassBean();
		cnbean.setCid(cid);
		cnbean.setCName(cName);
		new ClassDao().Add(cnbean); 
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='ClassManager.action';</script>");
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
