package cn.study.entity;
/**
 * 订单详情
 * @author think
 *
 */

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Detail {
	private Long did;//详情主键
	private Long orderid;//订单编号
	private Integer productid;//产品编号
	private Integer count;//购买数量
	//记录下单的时候，商品的价格。防止价格修改之后，订单总和的错误
	private BigDecimal price;//购买时的价格
	
	//连表时，需要添加临时字段
	private Timestamp otime;
	private BigDecimal total;
	private String pname;

	
	
	public Timestamp getOtime() {
		return otime;
	}
	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Detail(Long did, Long orderid, Integer productid, Integer count, BigDecimal price) {
		super();
		this.did = did;
		this.orderid = orderid;
		this.productid = productid;
		this.count = count;
		this.price = price;
	}
	public Detail() {
		super();
	}
	@Override
	public String toString() {
		return "Detail [did=" + did + ", orderid=" + orderid + ", productid=" + productid + ", count=" + count
				+ ", price=" + price + "]";
	}
	
	
	
	
}
