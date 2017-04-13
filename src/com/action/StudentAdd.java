package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ClassBean;
import com.dao.ClassDao;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAdd extends ActionSupport{
	private List<ClassBean> list;
	
		public List<ClassBean> getList() {
		return list;
	}

	public void setList(List<ClassBean> list) {
		this.list = list;
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
			//��ѯ����
			String strWhere="1=1";
			//��ѯ����
			list=new ClassDao().GetList(strWhere,"cid");
		
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
