package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class textDAO {
	private Connection con;
	private String title;
	private ResultSet rs_;

	public textDAO() throws DAOException {
		getConnection();
	}

	public int addTextbook(int id, String title, String author, int category, String status,
											int price, String info ) throws DAOException{
		if (con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "INSERT INTO textbooks(id, title, author, category, status, price, info, user_id) "
					+ "VALUES(?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, title);
			st.setInt(2, category);
			st.setInt(3, price);
			st.setString(4, status);
			st.setString(5, info);


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

	//部分一致するタイトルを検索
		private void close() throws SQLException {
			try {

				PreparedStatement st = null;
				ResultSet rs = null;

				Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			con=DriverManager.getConnection(url, user, pass);


				String sql ="select * from TextBook where title like ?";
				st=con.prepareStatement(sql);
				st.setString(1, "%" + title +"%");
				st=con.prepareStatement(sql);
				while(rs_.next())

					if (con != null) {
						con.close();
						con = null;
					}
				}
			}

		public List<TextbookBean> findAll() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
	}
