package com.bean;
public class StudentBean {
	private int student_ID;
	private String student_Num;
	private String student_Pwd;
	private String student_Class;
	private String student_Name;
	private String student_Gender;
	public int getStudent_ID() {
		return student_ID;
	}
	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}
	public String getStudent_Num() {
		return student_Num;
	}
	public void setStudent_Num(String student_Num) {
		this.student_Num = student_Num;
	}
	public String getStudent_Pwd() {
		return student_Pwd;
	}
	public void setStudent_Pwd(String student_Pwd) {
		this.student_Pwd = student_Pwd;
	}
	public String getStudent_Class() {
		return student_Class;
	}
	public void setStudent_Class(String student_Class) {
		this.student_Class = student_Class;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	public String getStudent_Gender() {
		return student_Gender;
	}
	public void setStudent_Gender(String student_Gender) {
		this.student_Gender = student_Gender;
	}
	@Override
	public String toString() {
		return "StudentBean [student_ID=" + student_ID + ", student_Num="
				+ student_Num + ", student_Pwd=" + student_Pwd
				+ ", student_Class=" + student_Class + ", student_Name="
				+ student_Name + ", student_Gender=" + student_Gender + "]";
	}
}
