package com.bean;
public class CourseBean {

	
//	CREATE TABLE `course` (
//			  `Course_ID` int(11) NOT NULL AUTO_INCREMENT,
//			  `Course_Name` varchar(50) NOT NULL,
//			  `Course_Address` varchar(50) NOT NULL,
//			  `Course_Capacity` int(11) NOT NULL,
//			  `Course_Start_Week` int(11) NOT NULL,
//			  `Course_End_Week` int(11) NOT NULL,
//			  `Course_WeekDay` int(11) NOT NULL,
//			  `Course_Start_Section` int(11) NOT NULL,
//			  `Course_End_Section` int(11) NOT NULL,
//			  PRIMARY KEY (`Course_ID`)
//			) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
	/* new selectedNum add in 4/11/2017 */
	private int selectedNum;
	
    public int getSelectedNum() {
		return selectedNum;
	}
	public void setSelectedNum(int selectedNum) {
		this.selectedNum = selectedNum;
	}
	/**  End */
	
	private int Course_ID ;
    private String Course_Name ;
    private String Course_Address ;
    private int Course_Capacity;
    private int Course_Start_Week;
    private int Course_End_Week;
    private int Course_WeekDay;
    private int Course_Start_Section;
    private int Course_End_Section;
	public int getCourse_ID() {
		return Course_ID;
	}
	public void setCourse_ID(int course_ID) {
		Course_ID = course_ID;
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	public String getCourse_Address() {
		return Course_Address;
	}
	public void setCourse_Address(String course_Address) {
		Course_Address = course_Address;
	}
	public int getCourse_Capacity() {
		return Course_Capacity;
	}
	public void setCourse_Capacity(int course_Capacity) {
		Course_Capacity = course_Capacity;
	}
	public int getCourse_Start_Week() {
		return Course_Start_Week;
	}
	public void setCourse_Start_Week(int course_Start_Week) {
		Course_Start_Week = course_Start_Week;
	}
	public int getCourse_End_Week() {
		return Course_End_Week;
	}
	public void setCourse_End_Week(int course_End_Week) {
		Course_End_Week = course_End_Week;
	}
	public int getCourse_WeekDay() {
		return Course_WeekDay;
	}
	public void setCourse_WeekDay(int course_WeekDay) {
		Course_WeekDay = course_WeekDay;
	}
	public int getCourse_Start_Section() {
		return Course_Start_Section;
	}
	public void setCourse_Start_Section(int course_Start_Section) {
		Course_Start_Section = course_Start_Section;
	}
	public int getCourse_End_Section() {
		return Course_End_Section;
	}
	public void setCourse_End_Section(int course_End_Section) {
		Course_End_Section = course_End_Section;
	}
	@Override
	public String toString() {
		return "CourseBean [Course_ID=" + Course_ID + ", Course_Name="
				+ Course_Name + ", Course_Address=" + Course_Address
				+ ", Course_Capacity=" + Course_Capacity
				+ ", Course_Start_Week=" + Course_Start_Week
				+ ", Course_End_Week=" + Course_End_Week + ", Course_WeekDay="
				+ Course_WeekDay + ", Course_Start_Section="
				+ Course_Start_Section + ", Course_End_Section="
				+ Course_End_Section + "]";
	}


    
	
}
