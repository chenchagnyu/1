package cn.study.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cn.study.dao.CategoryDAO;
import cn.study.dao.ProductDAO;
import cn.study.entity.Category;
import cn.study.entity.Product;

public class ProductTest {
	ProductDAO dao = new ProductDAO();
	CategoryDAO lei_dao = new CategoryDAO();
	
	public static void main(String[] args) {
		ProductTest test = new ProductTest();
		test.all();
	}
	
	public void all() {
		List<Product> ps = dao.selectAllAndCname();
		System.out.println("编号\t商品名字\t商品价格\t商品类别\t是否上架");
		for(Product p:ps) {
			//获取数据之后，转换成用户更好理解的内容，展出
			boolean isup = p.getIsup();
			String jia = isup?"已上架":"未上架";
			System.out.println(p.getPid()+"\t"+
							   p.getPname()+"\t"+
							   p.getPrice()+"\t"+
							   p.getCname()+"\t"+
							   jia);
//			System.out.println(p);
			//System.out.println("所属类别："+p.getCname());
		}
	}
	
	public void add() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入商品的名字：");
		String name = in.next();
		System.out.println("请输入商品的价格：");
		String P = in.next();
		System.out.println("请输入商品的品牌");
		String brand = in.next();
		System.out.println("请在下列类别中选择该商品所属类的编号：");
		List<Category> cs = lei_dao.selectAll();
		cs.forEach(c->
			System.out.println("编号:"+c.getCid()+
						   	   ",类名："+c.getCname()));
		Integer cid = in.nextInt();
		//判断输入的值，是否存在于列表中
		boolean flag = false;
		for(Category c:cs) {
			if(c.getCid().equals(cid)) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("你输入的类别编号不是正确的");
		}else {
			//组装Product实体类对象，是否上架（默认否）
			Product p = new Product(null, name, new BigDecimal(P), 
					brand, cid, false);
			//新增同时返回自增的主键
			Integer pid;
			try {
				pid = dao.doInsert(p);
				if(pid>0) {
					System.out.println("新增成功，主键是："+pid);
				}else {
					System.out.println("新增失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
