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

	//下面是Action内用于封装用户请求参数的属性
	private String WebURL;

	public String getWebURL() {
		return WebURL;
	}

	public void setWebURL(String webURL) {
		WebURL = webURL;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		System.out.println(WebURL + "******************");
		
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
		
		//添加
		List<StudentBean> list = getBatchImport();
		StudentDao stuDao = new StudentDao();
		for(StudentBean stdbean : list){
			stuDao.Add(stdbean); 
		}
		
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	public List<StudentBean> getBatchImport(){
		List<StudentBean> list = null;
		 try {
	            Document document = Jsoup.connect(WebURL).get();
	            System.out.println(WebURL);
	            if (document != null) {
	            	list = DataTableUtil.get(document);
	                //获取相应的table
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   
		return list;
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
}
