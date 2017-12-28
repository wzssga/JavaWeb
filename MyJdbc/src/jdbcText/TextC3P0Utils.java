package jdbcText;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

import jdbc_Utils.C3P0Utils;
import jdbc_Utils.DBCPUtils;
import jdbc_Utils.JdbcUtils;

public class TextC3P0Utils {
	    @Test
		public void textAdd() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			

			try {
				conn =DBCPUtils.getConnection();

				String sql = "insert into tlb_User values (?,?);";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "zxt");
				pstmt.setString(2, "nv2");
				int row = pstmt.executeUpdate();
				if (row > 0) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失敗！");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} finally {
				JdbcUtils.release(conn,pstmt,null);
			}
		}
}
