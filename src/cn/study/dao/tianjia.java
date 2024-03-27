package cn.study.dao;

import java.util.Scanner;

import cn.study.util.dao;

/**
* @Description: 
* @author: ccy
* @date 2023年12月20日 下午3:58:59
*/

public class tianjia extends dao {
	Scanner in = new Scanner(System.in);
	public void tj() {
		String sql="INSERT INTO Suhebule VALUES(null,?,?,?,?)";
		try {
			conn=super.getConn();
			stmt=conn.prepareStatement(sql);
			System.out.println("请输入出发地：");
			String cfd = in.next();
			stmt.setString(1,cfd);
			System.out.println("请输入目的地：");
			String mdd = in.next();
			stmt.setString(2,mdd);
			System.out.println("请输入出发时间：");
			String cfsj = in.next();
			stmt.setObject(3,cfsj);
			System.out.println("请输入到达时间：");
			String ddsj = in.next();
			stmt.setObject(4,ddsj);
			int a=stmt.executeUpdate();
			System.out.println("新增成功!");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		tianjia b = new tianjia();
		b.tj();
	}
}
