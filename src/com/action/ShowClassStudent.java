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
			//查询
			getClassName();//根据id获取班级名称
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
		//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println();
		}

}
