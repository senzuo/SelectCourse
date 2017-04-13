package com.dao;

import com.db.DBHelper;
import com.bean.CourseBean;
import com.bean.CourseStudentBean;

import java.util.*;
import java.sql.*;

public class CourseDao {
	
	//根据 list<course_studentbean> 中的cid 获取list<coursebean>
	public List<CourseBean> GetListByCSBean(List<CourseStudentBean> csbean){
		List<CourseBean> list=new ArrayList<CourseBean>();
		CourseBean cbean;
		CourseDao cd = new CourseDao();
		for(CourseStudentBean csb : csbean){
			cbean = cd.GetBean(csb.getCid());
			list.add(cbean);
		}
		return list;
	}
	//获取列表
	public List<CourseBean> GetList(String strwhere,String strorder){
		String sql="select * from Course";
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
		List<CourseBean> list=new ArrayList<CourseBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				CourseBean cnbean=new CourseBean();
				cnbean.setCourse_ID(rs.getInt("Course_ID"));
				cnbean.setCourse_Name(rs.getString("Course_Name"));
				cnbean.setCourse_Address(rs.getString("Course_Address"));
				cnbean.setCourse_Capacity(rs.getInt("Course_Capacity"));
				cnbean.setCourse_Start_Week(rs.getInt("Course_Start_Week"));
				cnbean.setCourse_End_Week(rs.getInt("Course_End_Week"));
				cnbean.setCourse_WeekDay(rs.getInt("Course_WeekDay"));
				cnbean.setCourse_Start_Section(rs.getInt("Course_Start_Section"));
				cnbean.setCourse_End_Section(rs.getInt("Course_End_Section"));
				
				int selectedNum = getSelectedNum(rs.getInt("Course_ID"));
				cnbean.setSelectedNum(selectedNum);
//				System.out.println(cnbean);
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
	private int getSelectedNum(int i){
		int num = 0;
		String sql="select * from course_student where cid = " + i;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				num++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
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
		return num;
	}
	
	
	
	
	
	//获取指定ID的实体Bean
	public CourseBean GetBean(int id){
		String sql="select * from Course where Course_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		CourseBean cnbean=new CourseBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setCourse_ID(rs.getInt("Course_ID"));
				cnbean.setCourse_Name(rs.getString("Course_Name"));
				cnbean.setCourse_Address(rs.getString("Course_Address"));
				cnbean.setCourse_Capacity(rs.getInt("Course_Capacity"));
				cnbean.setCourse_Start_Week(rs.getInt("Course_Start_Week"));
				cnbean.setCourse_End_Week(rs.getInt("Course_End_Week"));
				cnbean.setCourse_WeekDay(rs.getInt("Course_WeekDay"));
				cnbean.setCourse_Start_Section(rs.getInt("Course_Start_Section"));
				cnbean.setCourse_End_Section(rs.getInt("Course_End_Section"));
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
	public void Add(CourseBean cnbean){
		String sql="insert into Course (";
		sql+="Course_Name,Course_Address,Course_Capacity,Course_Start_Week,Course_End_Week,Course_WeekDay,Course_Start_Section,Course_End_Section";
		sql+=") values(";
		sql+="'"+cnbean.getCourse_Name()+"','"+cnbean.getCourse_Address()+"',"+cnbean.getCourse_Capacity()+","+cnbean.getCourse_Start_Week()+","+cnbean.getCourse_End_Week()+","+cnbean.getCourse_WeekDay()+","+cnbean.getCourse_Start_Section()+","+cnbean.getCourse_End_Section();
		sql+=")";
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
	public void Update(CourseBean cnbean){
		String sql="update Course set ";
		sql+="Course_Name='"+cnbean.getCourse_Name()+"',";
		sql+="Course_Address='"+cnbean.getCourse_Address()+"',";
		sql+="Course_Capacity="+cnbean.getCourse_Capacity()+",";
		sql+="Course_Start_Week="+cnbean.getCourse_Start_Week()+",";
		sql+="Course_End_Week="+cnbean.getCourse_End_Week()+",";
		sql+="Course_WeekDay="+cnbean.getCourse_WeekDay()+",";
		sql+="Course_Start_Section="+cnbean.getCourse_Start_Section()+",";
		sql+="Course_End_Section="+cnbean.getCourse_End_Section();
		
		
		sql+=" where Course_ID="+cnbean.getCourse_ID()+";";
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
		String sql="delete from course where ";
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

