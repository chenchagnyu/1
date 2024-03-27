package cn.study.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cn.study.dao.CategoryDAO;
import cn.study.entity.Category;

/**
 * 测试CategoryDAO这个类的方法
 * @author think
 *
 */
public class CategoryTest {
	//新增的类，必须保证表中不存在（保证新增的类名是唯一的）
	public static void demo() {
		CategoryDAO dao = new CategoryDAO();
		Scanner in =new Scanner(System.in);
		System.out.println("请输入你要新增的类名：");
		String name = in.next();
		//【要保证该输入的值，数据库有且仅有一个】
		//第一种
		//1、调用selectAll()查询所有类别
		//2、遍历判断name是否存在
		//3、遍历结束，name不存在，才调用doInsert方法
		//第二种，效率更高
		try {
			//1、调用方法selectByName()根据名字查询类别
			Category c1 = dao.selectByName(name);
			//2、如果查询的结果是null，表示不存在
			if(c1==null) {
				//3、调用doInsert方法
				Category c2 = new Category(null, name);
				Integer r = dao.doInsert(c2);
				if(r>0) {
					System.out.println("新增成功");
				}else {
					System.out.println("新增失败");
				}
			}else {
				System.out.println("该类别已存在，不能新增");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		demo();
//		CategoryDAO dao = new CategoryDAO();
//		
//		//2、根据输入的id，查询对应的商品信息
//		Scanner in  = new Scanner(System.in);
//		System.out.println("请输入你要查询的商品编号：");
//		int id = in.nextInt();
//		Category category = dao.selectById(id);
//		if(category==null) {
//			System.out.println("编号无对应的类别信息");
//		}else {
//			System.out.println("对应的类别是："
//						+category.getCname());
//		}
//		//3、新增的方法
//		System.out.println("请输入你要新增的类名：");
//		String name = in.next();
//		Category c1 = new Category(null, name);
//		Integer r1 = dao.doInsert(c1);
//		if(r1>0) {
//			System.out.println("新增成功咯");
//		}else {
//			System.out.println("新增失败咯");
//		}
//		//1、查询所有商品的类别
//		List<Category> list = dao.selectAll();
//		//遍历list集合有几种方法？
//		list.forEach(System.out::println);
	}
}
