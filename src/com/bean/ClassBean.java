package com.bean;

public class ClassBean {
	private int cid;
	private String cName;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "ClazzBean [cid=" + cid + ", cName=" + cName + "]";
	}
	

}
