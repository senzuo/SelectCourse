package com.dao;

import com.db.DBHelper;
import com.bean.CourseStudentBean;
import com.bean.StudentBean;

import java.util.*;
import java.sql.*;

public class StudentDao {
	
	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select * from student where student_num='"+username+"' and student_Pwd='"+password+"';";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("student_ID");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from student where student_ID='"+id+"' and student_Pwd='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}
	//获取所有列表
	public List<StudentBean> GetAllList(String strwhere,String strorder){
		String sql="select * from student";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StudentBean cnbean=new StudentBean();
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
				list.add(cnbean);
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
		return list;
	}
	//获取列表
	public List<StudentBean> GetList(String strwhere,String strorder){
		String sql="select * from student";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StudentBean cnbean=new StudentBean();
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
				list.add(cnbean);
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
		return list;
	}
	//获取指定ID的实体Bean
	public StudentBean GetAllFirstBean(String strwhere){
		String sql="select * from student where "+strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
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
		return cnbean;
	}
	//获取指定ID的实体Bean
	public StudentBean GetFirstBean(String strwhere){
		String sql="select * from student where "+strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
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
		return cnbean;
	}
	//获取指定ID的实体Bean
	public StudentBean GetAllBean(int id){
		String sql="select * from student where student_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
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
		return cnbean;
	}
	//获取指定ID的实体Bean
	public StudentBean GetBean(int id){
		String sql="select * from student where student_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("student_ID"));
				cnbean.setStudent_Num(rs.getString("student_Num"));
				cnbean.setStudent_Pwd(rs.getString("student_Pwd"));
				cnbean.setStudent_Class(rs.getString("student_Class"));
				cnbean.setStudent_Name(rs.getString("student_Name"));
				cnbean.setStudent_Gender(rs.getString("student_Gender"));
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
		return cnbean;
	}
	
	//添加
	public void Add(StudentBean cnbean){
		if(isRepeat(cnbean.getStudent_Num()))	return;
		String sql="insert into student (";
		sql+="student_Num,student_Pwd,student_Class,student_Name,student_Gender";
		sql+=") values(";
		sql+="'"+cnbean.getStudent_Num()+"','"+cnbean.getStudent_Pwd() +"','"
		+cnbean.getStudent_Class() +"','"+cnbean.getStudent_Name()+"','"
				+cnbean.getStudent_Gender()+"'";
		sql+=")";
		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
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
	//修改
	public void Update(StudentBean cnbean){
		String sql="update Student set ";
		sql+="student_Num='"+cnbean.getStudent_Num()+"',";
		sql+="student_Pwd='"+cnbean.getStudent_Pwd()+"',";
		sql+="student_Class='"+cnbean.getStudent_Class()+"',";
		sql+="student_Name='"+cnbean.getStudent_Name()+"',";
		sql+="student_Gender='"+cnbean.getStudent_Gender()+"'";
		
		sql+=" where student_ID='"+cnbean.getStudent_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
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
//	//删除
	public void Delete(String strwhere){
		String sql="delete from student where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
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
	
	public List<StudentBean> GetListByCourse(List<CourseStudentBean> cnbean){
		List<StudentBean> sbean = new ArrayList<StudentBean>();
		for(CourseStudentBean t : cnbean){
			StudentBean s = GetBean(t.getSid());
			sbean.add(s);
		}
		return sbean;
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	private boolean isRepeat(String StuNum){
		String sql="select * from student where student_Num="+StuNum;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean=new StudentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next())
				return true;
			else 
				return false;
			
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
		return false;
	}
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

