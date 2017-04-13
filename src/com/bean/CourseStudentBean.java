package com.bean;

public class CourseStudentBean {
	private int sid;
	private int cid;
	private int seatid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSeatid() {
		return seatid;
	}
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
	@Override
	public String toString() {
		return "CourseStudentBean [sid=" + sid + ", cid=" + cid + ", seatid="
				+ seatid + "]";
	}

}
