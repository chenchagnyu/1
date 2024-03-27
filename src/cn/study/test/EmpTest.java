package cn.study.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.study.dao.EmpDAO;
import cn.study.entity.Emp;

/**
* @Description: 
* @author: ccy
* @date 2023年7月7日 上午11:00:41
*/

public class EmpTest {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		try {
			List<Emp> emps = dao.selectBySearch("李", new BigDecimal("4000"), new BigDecimal("6000"));
			System.out.println("员工编号\t员工名称\t薪水\t入职日期\t部门名称");
			SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
			emps.forEach(e->{
				String d = sdf.format(e.getHireddate());
				System.out.printf("%d\t%4s\t%.1f\t%s\t%s\n",e.getEmpno(),e.getEname(),e.getSal(),d,e.getDname());
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
