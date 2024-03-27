package cn.study.dao;
/**
*详情表的DAO类，一个dao方法对应一条SQL语句
*五个基础的dao方法
*1、selectAll():List<实体类>
*2、selectById(主键)
*/

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.study.entity.Detail;
import cn.study.util.BaseDAO;

public class DetailDAO extends BaseDAO {
	
	public List<Detail> selectWheres(Long orderid,Timestamp otime,Integer ostatus,Integer uid) throws SQLException{
		//String类,不合适拼接频繁的操作
		//StringBuffer和StringBulider
		StringBuilder sb = new StringBuilder("SELECT d.*,o.`otime`,"
				+ "o.`total`,p.`pname` FROM detail d"
				+ " INNER JOIN orders o ON d.`orderid`=o.`oid`"
				+ "	INNER JOIN product p ON d.`productid`=p.`pid`"
				+ "where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (orderid!=null && orderid>0) {
			sb.append(" and o.oid=?");
			params.add(orderid);
		}
		if (otime!=null) {
			sb.append(" and o.time=?");
			params.add(otime);
		}
		if (ostatus!=null) {
			sb.append(" and o.ostatus=?");
			params.add(ostatus);
		}
		if (uid!=null) {
			sb.append(" and o.uid=?");
			params.add(uid);
		}
		
		try {
			//2、获取连接，利用预编译执行对象执行SQL语句
			stmt = getConn().prepareStatement(sb.toString());
			//3、绑定参数
			for(int i=0;i<params.size();i++) {
				stmt.setObject(i+1, params.get(i));
			}
			//4、执行SQL语句
			rs = stmt.executeQuery();
			System.out.println("执行的结果："+stmt);
			//5、将结果的数据转存到List集合
			List<Detail> ds=null;
			if (rs!=null) {
				ds=new ArrayList<>();
				while(rs.next()) {
					Detail d = new Detail(rs.getLong("did"),
							rs.getLong("orderid"),
							rs.getInt("productid"),
							rs.getInt("count"),
							rs.getBigDecimal("price"));
					//给临时字段赋值
					d.setOtime(rs.getTimestamp("otime"));
					d.setTotal(rs.getBigDecimal("total"));
					d.setPname(rs.getString("pname"));
					//将实体类（也就是数据库的一行数据）添加到集合中
					ds.add(d);
				}
			}
			return ds;
		} catch (SQLException e) {
			
			e.printStackTrace();
			//抛出异常
			throw e;
		}finally {
			super.closeAll();
		}
	}
}
