package com.action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.StudentBean;
import com.dao.CourseStudentDao;
import com.dao.StudentDao;
import com.db.DBHelper;
import com.opensymphony.xwork2.ActionSupport;

public class ShowClassStudent extends ActionSupport{


	private List<StudentBean> cnbean;
	private String ClazzName;
	private String cid;
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getClazzName() {
		return ClazzName;
	}
	public void setClazzName(String clazzName) {
		ClazzName = clazzName;
	}
	public List<StudentBean> getCnbean() {
		return cnbean;
	}
	public void setCnbean(List<StudentBean> cnbean) {
		this.cnbean = cnbean;
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
			//��ѯ
			getClassName();//����id��ȡ�༶����
			cnbean=new StudentDao().GetList("student_Class='"+ClazzName+"'","student_ID");
//			for(StudentBean sb : cnbean){
//				System.out.println(sb);
//			}
			return SUCCESS;
			
		}
		private void getClassName(){
			String sql="select * from clazz where cid="+cid;
//			System.out.println(sql);
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			StudentBean cnbean=new StudentBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				if(rs.next()){
					this.setClazzName(rs.getString("cName"));
//					System.out.println("ClazzName is ++++++++++ " + ClazzName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
