package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InquiryDAO {
	private Connection con;

	public InquiryDAO() throws DAOException {
		getConnection();
	}
	public int newInquiry(String content, int userId) throws DAOException{
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "INSERT INTO inquiries(content, user_id) VALUES(?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, content);
			st.setInt(2, userId);

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
	public int deleteInquiryById(int id) throws DAOException{
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "DELETE FROM inquiries WHERE id = ?";
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
	public List<InquiryBean> findAll() throws DAOException{
		if (con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql ="SELECT * FROM inquiries JOIN members ON inquiries.user_id = members.id";
			st=con.prepareStatement(sql);
			rs = st.executeQuery();

			List<InquiryBean> list = new ArrayList<InquiryBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				int userId = rs.getInt("user_id");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String userName = lastName + firstName;
				String email = rs.getString("email");

				InquiryBean bean = new InquiryBean(id, content, userId, userName, email);
			    list.add(bean);
			}
			return list;
		} catch (SQLException e){
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
				close();
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
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
