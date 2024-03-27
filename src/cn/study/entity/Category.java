package cn.study.entity;
/**
 * 实体类，对应category数据库表
 * @author think
 * 1、类名就是表名（单词首字母大写）
 * 2、属性就是列名
 */
public class Category {
	//1、属性私有化
	private Integer cid;
	private String cname;
	//2、公开的getter和setter方法
	//3、全参和无参
	//4、toString
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
