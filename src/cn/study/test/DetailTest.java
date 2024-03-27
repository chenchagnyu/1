package cn.study.test;

import java.sql.SQLException;

import cn.study.dao.DetailDAO;

public class DetailTest {
	public static void main(String[] args) {
		//测试方法
		DetailDAO dao = new DetailDAO();
		try {
			dao.selectWheres(null, null, null, null);
			dao.selectWheres(10000001L, null, null, null);
			dao.selectWheres(10000002L, null, null, 1);
			dao.selectWheres(10000001L, null, 1, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
