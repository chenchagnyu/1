package cn.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import cn.study.*;
import cn.study.entity.Suhebule;
import cn.study.util.dao;
import cn.study.util.dao;
/**
* @Description: 
* @author: ccy
* @date 2023年12月19日 下午4:23:57
*/

public class SuhebuleDAO extends dao {
	public List<Suhebule> selectBySearch1() throws SQLException {
		String sql="select * from Suhebule;";

		try {
			stmt=getConn().prepareStatement(sql);
			rs=stmt.executeQuery();
			List<Suhebule> list=null ;
			if (rs!=null) {
				list= new ArrayList<>();
				while (rs.next()) {
					Suhebule co = new Suhebule(rs.getInt("sid"),rs.getString("splace"),rs.getString("dest"),rs.getDate("depar"),rs.getDate("arrival"));
				list.add(co);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			super.closeAll();
		}
	}
	public void xc() {
		List<Suhebule> co;
		try {
			co=selectBySearch1();
//			int s =1;//记录编号
			for (Suhebule pr: co) {//遍历数组
				System.out.println("\t  "+pr.getSid()+"\t  "+pr.getSplace()+"\t "+pr.getDest()+"\t "+pr.getDepar()+"\t"+pr.getArrival());
//				s++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
