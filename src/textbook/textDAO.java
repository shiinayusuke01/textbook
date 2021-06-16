package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class textDAO {
	private Connection con;
	private String title;
	private ResultSet rs_;

	public textDAO() throws DAOException {
		getConnection();
	}
	public List<TextbookBean> findAllTextbook() throws DAOException {
		if (con == null)
		getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

	try {
		String sql ="select * from TextBook where title like ?";
		st=con.prepareStatement(sql);
		st.setString(1, "%" + title +"%");
		rs = st.executeQuery();

		List<TextbookBean> list = new ArrayList<TextbookBean>();
		while (rs.next()) {
			    String title = rs.getString("title");
			    String author = rs.getString("author");
			    String category = rs.getString("category");
			    String price = rs.getString("price");
			    String status = rs.getString("status");
			    String info = rs.getString("info");

			    TextbookBean bean = new TextbookBean(title, author,category,price,status,info);
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