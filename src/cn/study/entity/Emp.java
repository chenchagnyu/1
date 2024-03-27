package cn.study.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
* @Description: 
* @author: ccy
* @date 2023年7月7日 上午10:22:00
*/

public class Emp {
	private Integer empno;//编号
	private String ename;//名字
	private String job;//职位
	private BigDecimal sal;//工资
	private BigDecimal comm;//薪水
	private Date hireddate;//入职日期
	private Integer mgr;//上级编号
	private Integer deptno;//部门编号
	private String dname;
	private String loc;
	
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public BigDecimal getSal() {
		return sal;
	}
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}
	public BigDecimal getComm() {
		return comm;
	}
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	public Date getHireddate() {
		return hireddate;
	}
	public void setHireddate(Date hireddate) {
		this.hireddate = hireddate;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	public Emp(Integer empno, String ename, String job, BigDecimal sal, BigDecimal comm, Date hireddate, Integer mgr,
			Integer deptno, String dname, String loc) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.hireddate = hireddate;
		this.mgr = mgr;
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", comm=" + comm
				+ ", hireddate=" + hireddate + ", mgr=" + mgr + ", deptno=" + deptno + ", dname=" + dname + ", loc="
				+ loc + "]";
	}
	
	
	
	
}
