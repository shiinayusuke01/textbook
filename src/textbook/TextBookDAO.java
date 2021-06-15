package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TextBookDAO {
	private Connection con;

	public TextBookDAO() throws DAOException {
		getConnection();
	}

	public int addTextbook(String title, String author, int category, String status, int price, String info, int userId ) throws DAOException{

		System.out.println(status);

		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "INSERT INTO textbooks(title, author, category, status, price, info, user_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, title);
			st.setString(2, author);
			st.setInt(3, category);
			st.setString(4, status);
			st.setInt(5, price);
			st.setString(6, info);
			st.setInt(7, userId);



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
