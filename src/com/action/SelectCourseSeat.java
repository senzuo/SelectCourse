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

	//下面是Action内用于封装用户请求参数的属性
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
		
//		//查询名称是否存在
//		List<CourseStudentBean> list=new CourseStudentDao().GetList("cid="+ cid + " sid="+sid , "");
//		if(list.size()>0)
//		{
//			out.print("<script language='javascript'>alert('已经存在！');history.back(-1);</script>");
//			out.flush();out.close();return null;
//		}
		//修改
		CourseStudentBean cnbean=new CourseStudentBean();
		cnbean.setCid(Integer.parseInt(cid));
		cnbean.setSeatid(Integer.parseInt(seatid));
		cnbean.setSid(Integer.parseInt(sid));
		System.out.println(cnbean);
		new CourseStudentDao().Add(cnbean); 
		
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='CourseManager.action';</script>");
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
