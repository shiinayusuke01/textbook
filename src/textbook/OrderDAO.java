package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
	private Connection con;

	public OrderDAO() throws DAOException {
		getConnection();
	}

	public int deleteordered(int id) throws DAOException{

		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "DELETE FROM textbooks WHERE id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);

			// SQLの実行
			int rows = st.executeUpdate();
			// カテゴリ一覧をListとして返す
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}


		private void getConnection() throws DAOException {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new DAOException("接続に失敗しました。");
			}

			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				throw new DAOException("接続に失敗しました。");
			}
		}

		private void close() throws SQLException {
			if (con != null) {
				con.close();
				con = null;
			}
		}

}