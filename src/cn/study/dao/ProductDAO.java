package cn.study.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.study.entity.Product;
import cn.study.util.BaseDAO;
//继承父类BaseDAO
public class ProductDAO extends BaseDAO{
	/**
	 * 查询所有
	 * @return
	 */
	public List<Product> selectAll(){
		//1、准备sql语句，按照主键倒序
		String sql="select * from product order by pid desc";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			
			//5、执行SQL语句，查询数据都在结果集中
			rs = stmt.executeQuery();
			//6、将结果集转存到集合中
			List<Product> list = null;
			if(rs!=null) {
				list = new ArrayList<>();
				while(rs.next()) {
					Product p = fetchProduct(rs);
					list.add(p);//添加对象到集合中
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return null;//代码走到这，表示没有查询结果，或者报错
	}

	/**
	 * 从结果集中获取数据，生成一个产品实体类对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Product fetchProduct(ResultSet rs) throws SQLException {
		Product p = new Product(
				rs.getInt("pid"),
				rs.getString("pname"), 
				rs.getBigDecimal("price"), 
				rs.getString("brand"), 
				rs.getInt("categoryid"), 
				rs.getBoolean("isup"));
		return p;
	}
	
	/**新增产品，并且返回新增的主键（自增主键列）
	 * 下面的代码适用于以下情况
	 * 1、主键是自增列  auto_increment
	 * 2、主键的类型是int\smallint\mediumint
	 * @throws SQLException 
	 */
	public Integer doInsert(Product pro) throws SQLException {
		String sql="insert into product values(null,?,?,?,?,?)";
		try {
			//2、获取连接对象，并且利用预编译执行对象，编译SQL语句
			//在预编译的时候，告诉执行对象，返回自增的主键值
			stmt = super.getConn()
					.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
			//3、填充参数
			stmt.setObject(1, pro.getPname());
			stmt.setObject(2, pro.getPrice());
			stmt.setObject(3, pro.getBrand());
			stmt.setObject(4, pro.getCategoryid());
			stmt.setObject(5, pro.getIsup());
			//4、执行SQL语句
			Integer r = stmt.executeUpdate();
			//5、获取返回的主键结果集(单行单列)
			rs = stmt.getGeneratedKeys();
			//6、获取结果集中的第一行的第一列的值（自增的主键）
			if(rs!=null) {
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//抛出异常
			throw e;
		}finally {
			//关闭连接
			super.closeAll();
		}
		//如果代码能够运行到这里，表示新增失败了
		return -1;		
	}

	public List<Product> selectAllAndCname(){
		//1、准备sql语句，按照主键倒序
		String sql="select p.*,c.cname from product p left join category c on p.categoryid=c.cid";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			
			//5、执行SQL语句，查询数据都在结果集中
			rs = stmt.executeQuery();
			//6、将结果集转存到集合中
			List<Product> list = null;
			if(rs!=null) {
				list = new ArrayList<>();
				while(rs.next()) {
					Product p = fetchProduct(rs);
					//因为查询中多出了一个类别表的字段
					//1、在Product实体类中，添加类名的临时字段
					//2、在查询方法中，添加临时字段的值
					p.setCname(rs.getString("cname"));
					list.add(p);//添加对象到集合中
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return null;//代码走到这，表示没有查询结果，或者报错
	}
}
