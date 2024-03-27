package cn.study.entity;
/**
 * 实体类，放在entity包中，是数据库表在java的载体
 * 1、类名就是表名（单词首字母大写）
 * 2、属性就是数据库表的字段/列名
 * 		属性的数据类型，一律使用引用数据类型
 * 			mysql的数据类型		java数据类型
 * _____________________________________________
 * 			smallint/int			Integer
 * 			bigint					Long
 * 			decimal					BigDecimal
 * 			varchar/char/text		String
 * 			date					sql.Date
 * 			timestamp				sql.Timestamp
 * 			tinyint(1)				Integer/Boolean
 * 
   3、属性私有化，生成公开的getter和setter方法
   4、生成全参和无参构造方法
   5、重写toString()
 *
 */
import java.math.BigDecimal;
public class Product {
	//1、属性私有化
	private Integer pid;//商品编号
	private String pname;//商品名字
	private BigDecimal price;//商品价格
	private String brand;//商品品牌
	private Integer categoryid;//类别编号
	private Boolean isup;//是否上架。
	//mysql类型tinyint(1),值只有0和1，可以在java中用boolean来表示
	
	//类别名称不是产品表的，是连表操作时才会需要显示的字段-->临时字段
	private String cname;
	//给临时字段添加getter和setter方法
	
	
	//2、生成公开的getter和setter方法
	//3、生成全参和无参构造方法
	//4、重写toString方法
	
	public Integer getPid() {
		return pid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", brand=" + brand + ", categoryid="
				+ categoryid + ", isup=" + isup + "]";
	}
	public Product() {
		super();
	}
	public Product(Integer pid, String pname, BigDecimal price, String brand, Integer categoryid, Boolean isup) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.brand = brand;
		this.categoryid = categoryid;
		this.isup = isup;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Boolean getIsup() {
		return isup;
	}
	public void setIsup(Boolean isup) {
		this.isup = isup;
	}
	
	
	
}
