package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.bean.*;
import com.dao.*;


public class StudentBatchImport extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String WebURL;

	public String getWebURL() {
		return WebURL;
	}

	public void setWebURL(String webURL) {
		WebURL = webURL;
	}

	//�����û������execute����
	public String execute() throws Exception {
		System.out.println(WebURL + "******************");
		
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
		
		//���
		List<StudentBean> list = getBatchImport();
		StudentDao stuDao = new StudentDao();
		for(StudentBean stdbean : list){
			stuDao.Add(stdbean); 
		}
		
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	public List<StudentBean> getBatchImport(){
		List<StudentBean> list = null;
		 try {
	            Document document = Jsoup.connect(WebURL).get();
	            System.out.println(WebURL);
	            if (document != null) {
	            	list = DataTableUtil.get(document);
	                //��ȡ��Ӧ��table
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   
		return list;
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
}
