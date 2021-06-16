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

	public int saveOrder(MembersBean member, CartBean cart) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			int orderNumber = 0;
			sql = "SELECT nextval('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				orderNumber = rs.getInt(1);
			}
			rs.close();
			st.close();

			sql = "INSERT INTO ordered VALUES('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				orderNumber = rs.getInt(1);
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
			String sql = "INSERT INTO members(last_name, first_name, postal, address, tel, email, birthday, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, members.getLast_name());
			st.setString(2, members.getFirst_name());
			st.setString(3, members.getPostal());
			st.setString(4, members.getAddress());
			st.setString(5, members.getTel());
			st.setString(6, members.getEmail());
			st.setString(7, members.birthday(members.getYear(), members.getMonth(), members.getDay()));
			st.setString(8, members.getPassword());
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e){
			e.printStackTrace();
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

	public int changeMembers(MembersBean members) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			String sql = "UPDATE members SET last_name=?, first_name=?, postal=?, adderss=?, tel=?, email=?, birthday=?, password=?)";
			st = con.prepareStatement(sql);
			st.setString(1, members.getLast_name());
			st.setString(2, members.getFirst_name());
			st.setString(3, members.getPostal());
			st.setString(4, members.getAddress());
			st.setString(5, members.getTel());
			st.setString(6, members.getEmail());
			st.setString(7, members.birthday(members.getYear(), members.getMonth(), members.getDay()));
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