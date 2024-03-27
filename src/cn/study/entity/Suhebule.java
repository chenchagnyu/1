package cn.study.entity;

import java.util.Date;

/**
* @Description: 
* @author: ccy
* @date 2023年12月19日 下午4:16:47
*/

public class Suhebule {
	private Integer sid;//行程id
	private String splace;//出发地
	private String dest;//目的地
	private Date depar;//出发时间
	private Date arrival;//到达时间
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSplace() {
		return splace;
	}
	public void setSplace(String splace) {
		this.splace = splace;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public Date getDepar() {
		return depar;
	}
	public void setDepar(Date depar) {
		this.depar = depar;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Suhebule(Integer sid, String splace, String dest, Date depar, Date arrival) {
		super();
		this.sid = sid;
		this.splace = splace;
		this.dest = dest;
		this.depar = depar;
		this.arrival = arrival;
	}
	public Suhebule() {
		super();
	}
	
	@Override
	public String toString() {
		return "Suhebule [sid=" + sid + ", splace=" + splace + ", dest=" + dest + ", depar=" + depar + ", arrival="
				+ arrival + "]";
	}
	
	
	
}
