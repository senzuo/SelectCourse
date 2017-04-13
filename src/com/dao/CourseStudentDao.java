package com.dao;

import com.db.DBHelper;
import com.bean.CourseStudentBean;

import java.util.*;
import java.sql.*;

public class CourseStudentDao {
	
	//获取列表
	public List<CourseStudentBean> GetList(String strwhere,String strorder){
		String sql="select * from course_student";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<CourseStudentBean> list=new ArrayList<CourseStudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				CourseStudentBean cnbean=new CourseStudentBean();
				cnbean.setCid(rs.getInt("cid"));
				cnbean.setSid(rs.getInt("sid"));
				cnbean.setSeatid(rs.getInt("seatid"));
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
	
	//获取指定课程ID list集合
	public List<CourseStudentBean> GetCourseListByCid(int id){
		String sql="select * from course_student where cid="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<CourseStudentBean> list=new ArrayList<CourseStudentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			CourseStudentBean cnbean = null;
			while(rs.next()){
				cnbean = new CourseStudentBean();
				cnbean.setCid(rs.getInt("cid"));
				cnbean.setSid(rs.getInt("sid"));
				cnbean.setSeatid(rs.getInt("seatid"));
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
	
	//添加
	public void Add(CourseStudentBean cnbean){
		String sql="insert into course_student(";
		sql+="sid,cid,seatid ";
		sql+=") values(";
		sql+= cnbean.getSid()+","+cnbean.getCid() + "," + cnbean.getSeatid();
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
	public void Update(CourseStudentBean cnbean){
		String sql="update course_student set seatid=" + cnbean.getSeatid() + " where cid="+cnbean.getCid()+"and sid = "+cnbean.getSid()+";";
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
	//删除
	public void Delete(String strwhere){
		String sql="delete from course_student where ";
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

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

