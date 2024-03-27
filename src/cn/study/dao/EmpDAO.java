package cn.study.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.study.entity.Emp;
import cn.study.util.BaseDAO;

/**
* @Description: 
* @author: ccy
* @date 2023年7月7日 上午10:26:36
*/

public class EmpDAO extends BaseDAO{
	public List<Emp> selectBySearch(String word,BigDecimal begin,BigDecimal end)throws SQLException{
		String sql="SELECT * FROM emp e LEFT JOIN"+ " dept d ON e.`deptno`=d.`deptno`"+ "WHERE ename LIKE ? AND (sal BETWEEN ? AND ?)";									
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, "%"+word+"%");
			stmt.setObject(2, begin);
			stmt.setObject(3, end);
			rs = stmt.executeQuery();
			List<Emp> list=null;
			if (rs!=null) {
				list = new ArrayList<>();
				while(rs.next()) {
					Emp emp = new Emp(rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getBigDecimal("sal"),
							rs.getBigDecimal("comm"),
							rs.getDate("hiredate"),
							rs.getInt("mgr"),
							rs.getInt("deptno"),
							rs.getString("dname"),
							rs.getString("loc"));
//					emp.setDname(rs.getString("dname"));
//					emp.setLoc(rs.getString("loc"));
					list.add(emp);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			super.closeAll();
		}
	}
}
