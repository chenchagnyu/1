package cn.study.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
//订单实体类

public class Orders {
	private Long oid;//订单编号
	private Timestamp otime;//下单时间
	private Integer uid;//下单的用户
	private Integer ostatus;//订单状态
	private BigDecimal total;//订单总价
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public Timestamp getOtime() {
		return otime;
	}
	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Orders(Long oid, Timestamp otime, Integer uid, Integer ostatus, BigDecimal total) {
		super();
		this.oid = oid;
		this.otime = otime;
		this.uid = uid;
		this.ostatus = ostatus;
		this.total = total;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", otime=" + otime + ", uid=" + uid + ", ostatus=" + ostatus + ", total=" + total
				+ "]";
	}
	
}
