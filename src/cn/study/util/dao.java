package cn.study.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @Description: 
* @author: ccy
* @date 2023年10月30日 下午2:36:49
*/

public class dao {
	//①连接对象
		protected Connection conn;
		//②预编译执行对象
		protected PreparedStatement stmt;
		//③结果集对象
		protected ResultSet rs;
		//第一个字符串：mysql驱动包的全类名
		private static final 
			String DRIVER="com.mysql.cj.jdbc.Driver";
		//第二个字符串：mysql服务器的连接地址
		private final String URL="jdbc:mysql://127.0.0.1:3306/ccy?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8";
		//第三个字符串：mysql服务器的用户名
		private final String USER="root";
		//第四个字符串：mysql服务器的密码
		private final String PWD="123456";
		
		//利用静态块加载驱动（自动执行且只会执行一次，类对象创建之前）
		static {
			
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
	System.out.println("驱动加载失败，请确认是否导入了mysql的jar包");
				e.printStackTrace();
			}
		}
		/**
		 * 获取连接对象
		 * @return
		 * @throws SQLException
		 */
		public Connection getConn() throws SQLException {
			if(conn==null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, USER, PWD);
			}
			return conn;
		}
		/**
		 * 关闭连接，释放资源
		 */
		public void closeAll() {
			//关闭的顺序：先创建的后关闭 
			//独立的try……catch结构，可以保证任何一个对象关闭报错，
			//									都不会影响其他对象的关闭
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("结果集已被关闭...");
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		 
}
