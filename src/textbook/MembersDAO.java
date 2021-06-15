package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersDAO {
	private Connection con;

	public MembersDAO() throws DAOException {
		getConnection();
	}

	public List<MembersBean> findAllMembers() throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM members";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<MembersBean> list = new ArrayList<MembersBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
			    String family_name = rs.getString("family_name");
			    String first_name = rs.getString("first_name");
			    String postal = rs.getString("postal");
			    String address = rs.getString("address");
			    String tel = rs.getString("tel");
			    String email = rs.getString("email");
			    String birthday = rs.getString("birthday");
			    String password = rs.getString("password");

			    MembersBean bean = new MembersBean(id, family_name, first_name, postal, address, tel, email, birthday, password);
			    list.add(bean);
			}
			return list;
		} catch (SQLException e){
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

	public int newMembers(MembersBean members) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			String sql = "INSERT INTO members VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, members.getFamily_name());
			st.setString(2, members.getFirst_name());
			st.setString(3, members.getPostal());
			st.setString(4, members.getAddress());
			st.setString(5, members.getTel());
			st.setString(6, members.getEmail());
			st.setString(7, members.getBirthday());
			st.setString(8, members.getPassword());
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e){
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				close();
			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		  }
	}

	public int deleteMembers(MembersBean members) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			String sql = "DELETE FROM members Where id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, members.getId());
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e){
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				if (st != null) {
					st.close();
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