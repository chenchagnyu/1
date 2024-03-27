package cn.study.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.study.entity.Category;
import cn.study.util.BaseDAO;

/**
 * 一个数据库的表--->一个实体类---->一个DAO类
 * DAO类的作用是完成对应数据库表的原子性（CURD）操作
 * 一个DAO最基础的5个方法
 * 1、selectAll():List<实体类>  查询所有
 * 2、selectById(主键):实体类	  根据主键查询单条记录
 * 3、doInsert(实体类):int	  新增
 * 4、doUpdate(实体类):int	  修改
 * 5、doDelete(主键):int		  删除
 * 
 * 根据具体的业务逻辑，增加其他的DAO方法
 * 6、selectByName(String cname):实体类
 */
public class CategoryDAO extends BaseDAO{
	
	/**
	 * 根据名字查询单条记录（因为名字控制了是唯一的）
	 * @param cname
	 * @return
	 * @throws SQLException
	 */
	public Category selectByName(String cname) throws SQLException {
		//按照类别名称查询所有列
		String sql="select * from category where cname=?";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1, cname);
			//5、执行SQL语句
			rs = stmt.executeQuery();
			//6、将结果集中的一条数据，转存到实体类中
			if(rs!=null) {
				while(rs.next()) {
					return new Category(rs.getInt("cid"), 
							rs.getString("cname"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//抛出异常，谁调用谁处理
			throw e;
		}finally {
			//关闭资源
			super.closeAll();
		}
		return null;//代码运行到这里，说明没有查询到数据
		
	}
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Category> selectAll(){
		//1、查询category表的所有记录，并按照主键倒序
		String sql="select * from category "
							+ "order by cid desc";
		try {
			//2、获取连接对象
			conn = getConn();
			//3、利用预编译执行对象，执行SQL
			stmt = conn.prepareStatement(sql);
			//4、填充参数（sql语句中有几个占位符?，就填充几个参数）
			
			//5、将查询的结果，存储到结果集对象
			rs = stmt.executeQuery();
			//6、将结果集中的数据转存到集合中
			List<Category> list=null;
			if(rs!=null) {
				list = new ArrayList<>();
				while(rs.next()) {
					//调用rs.getXXX("列名")获取游标指向行的数据
					Integer cid = rs.getInt("cid");
					String cname = rs.getString("cname");
					//将获取到的数据，封装到实体的对象中
					//一行记录----》一个对象
					Category obj = new Category(cid, cname);
					//将对象添加到集合中
					list.add(obj);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return null;
	}
	/**
	 * selectById(主键):实体类	  根据主键查询单条记录
	 * @param cid
	 * @return
	 */
	public Category selectById(Integer cid) {
		//1、查询SQL语句
		String sql="select * from category where cid=?";
		try {
			//2、获取连接
			conn = super.getConn();
			//3、预编译执行对象，执行sql
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1, cid);
			//5、执行SQL语句，返回到结果集对象
			rs = stmt.executeQuery();
			//6、根据主键查询，最多返回一条记录
			if(rs!=null) {
				while(rs.next()) {
					Integer id = rs.getInt("cid");
					String cname=rs.getString("cname");
					//一行记录---》一个对象
					Category obj = new Category(id, cname);
					return obj;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭连接，释放资源
			super.closeAll();
		}
		return null;
	}
	
	/**
	 * doInsert(实体类):int	  新增
	 * @param obj
	 * @return
	 */
	public Integer doInsert(Category obj) {
		//1、准备新增的sql语句
		String sql="INSERT INTO category VALUES(NULL,?)";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1, obj.getCname());
			//5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return -1;//最后返回-1，表示代码运行到这里，新增失败
	}
	/**
	 * doUpdate(实体类):int	  修改
	 * @param obj
	 * @return
	 */
	public Integer doUpdate(Category obj) {
		//1、准备修改的sql语句
		String sql="update category set cname=? where cid=?";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1, obj.getCname());
			stmt.setObject(2, obj.getCid());
			//5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return -1;//最后返回-1，表示代码运行到这里，修改失败
	}
	/**
	 * doDelete(主键):int		  删除
	 * @param cid
	 * @return
	 */
	public Integer doDelete(Integer cid) {
		//1、准备删除的sql语句
		String sql="delete from category where cid=?";
		try {
			//2、获取连接对象
			conn = super.getConn();
			//3、预编译SQL语句
			stmt = conn.prepareStatement(sql);
			//4、填充参数
			stmt.setObject(1, cid);
			//5、执行SQL语句
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return -1;//最后返回-1，表示代码运行到这里，新增失败
	}
	
}
