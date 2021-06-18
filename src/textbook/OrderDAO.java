package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

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
			int user_Id = 0;
			String sql = "SELECT nextval('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
			user_Id = rs.getInt(1);
			}
			rs.close();
			st.close();

			sql = "INSERT INTO ordered VALUES('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
			user_Id = rs.getInt(1);
			}

			rs.close();
			st.close();

			sql = "INSERT INTO members VALUES(?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, member.getLast_name());
			st.setString(2, member.getFirst_name());
			st.setString(3, member.getAddress());
			st.setString(4, member.getTel());
			st.setString(5, member.getEmail());

			st.executeUpdate();
			st.close();

			int orderNumber = 0;
			sql = "SELECT nextval('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				orderNumber = rs.getInt(1);
			}
			rs.close();
			st.close();

			sql = "INSERT INTO ordered_detail VALUES(?, ?, ?)";
			st = con.prepareStatement(sql);

			Map<Integer, TextbookBean> items = cart.getItems();
			Collection<TextbookBean> list =items.values();
			for(TextbookBean item:list) {
				st.setInt(1, orderNumber);
				st.setInt(2, item.getPrice());
				st.setInt(3, item.getQuantity());
				st.executeUpdate();
			}
			st.close();
			return orderNumber;
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