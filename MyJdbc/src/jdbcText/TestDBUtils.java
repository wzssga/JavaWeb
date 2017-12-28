package jdbcText;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import jdbc.domain.User;
import jdbc_Utils.C3P0Utils;
/*测试DButils工具包
 */
public class TestDBUtils {
	@Test
	public void testAdd() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "insert into tlb_user values(?,?)";
			// 3为占位符设定值
			Object[] params = { "hello", "world" };
			// 4 执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("添加成功.");
			} else {
				System.out.println("添加失败.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void testUpdataPassWordByName() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "update tlb_user set upassward=? where uname=?";
			// 3为占位符设定值
			Object[] params = { "xxx", "hello" };
			// 4 执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("修改成功.");
			} else {
				System.out.println("修改失败.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void testDeleteUserByName() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "delete from tlb_user where uname=?";
			// 3为占位符设定值
			Object[] params = { "hello" };
			// 4 执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("删除成功.");
			} else {
				System.out.println("删除失败.");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询所用用户方法
	 */
	@Test
	public void testQueryAll() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "select * from tlb_user";
			// 3为占位符设定值
			Object[] params = { "hello" };
			// 3执行添加操作
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users) {
				System.out.println(user.getUname() + "   " + user.getUpassword());
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询所用用户方法 map
	 */
	@Test
	public void testQueryAllMap() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "select * from tlb_user";

			// 3执行添加操作
			List<Map<String, Object>> users = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : users) {
				System.out.println(map);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询所用用户方法 map
	 */
	@Test
	public void testQueryAllColumn() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "select * from tlb_user";

			// 3执行添加操作
			List<Object> users = qr.query(sql, new ColumnListHandler("uname"));
			for (Object object : users) {
				System.out.println(object);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询指定用户方法
	 */
	@Test
	public void testQueryByUname() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "select * from tlb_user where uname=?";
			// 3为占位符设定值
			Object[] params = { "hello" };
			// 4执行添加操作
			User user = qr.query(sql, new BeanHandler<User>(User.class), params);
			System.out.println(user.getUname() + "   " + user.getUpassword());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询所有用户的数目
	 */
	@Test
	public void testQueryCount() {
		try {
			// 1创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2编写sql语句
			String sql = "select count(*) from tlb_user";
			// 4执行添加操作
			long count = (long) qr.query(sql, new ScalarHandler());
			// System.out.println(user.getUname() + " " + user.getUpassword());
			System.out.println("count=" + count);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
