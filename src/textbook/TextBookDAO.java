package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TextBookDAO {
	private Connection con;

	public TextBookDAO() throws DAOException {
		getConnection();
	}

	public int newTextbook(String title, String author, int category, String status, int price, String info, int userId ) throws DAOException{

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
	  public List<CategoryBean> findAllCategory() throws DAOException{
	    	if (con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
	    	try {

	    		String sql = "SELECT * FROM category ORDER BY code";
	    		st = con.prepareStatement(sql);
	    		rs = st.executeQuery();

	    		 List<CategoryBean> list =new ArrayList<CategoryBean>();
	    		 while(rs.next()) {
	    			 int code = rs.getInt("code");
	    			 String name = rs.getString("name");
	    			 CategoryBean bean = new CategoryBean(code, name);
	    			 list.add(bean);
	    		 }
	    		 return list;
	    	} catch (Exception e) {
	    		e.printStackTrace();
				throw new DAOException("レコードの取得にに失敗しました。");
	    } finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    			close();
	    	}catch(Exception e) {
	    		throw new DAOException("リソースの開放に失敗しました。");
	    	}
	    }
	  }
	     public List<ItemBean> findByCategory(int categoryCode)

	    throws DAOException {
	    	 if (con == null)
	     		getConnection();

	    	 PreparedStatement st = null;
	     	ResultSet rs = null;
	     	try {

	     		String sql = "SELECT * FROM item WHERE category_code = ? ORDER BY code";
	     		st = con.prepareStatement(sql);
	     		st.setInt(1, categoryCode);
	     		rs = st.executeQuery();

	     		 List<ItemBean> list =new ArrayList<ItemBean>();
	     		 while(rs.next()) {
	     			 int code = rs.getInt("code");
	     			 String name = rs.getString("name");
	     			 int price = rs.getInt("price");
	     			 String quantity = rs.getString("quantity");
	     			 ItemBean bean = new ItemBean(code, name, price);
	     			 list.add(bean);
	     		 }
	     		 return list;
	     	} catch (Exception e) {
	     		e.printStackTrace();
	 			throw new DAOException("レコードの取得に失敗しました。");
	     } finally {
	     	try {
	     		if (rs != null) rs.close();
	     		if (st != null) st.close();
	     			close();
	     	}catch(Exception e) {
	     		throw new DAOException("リソースの開放に失敗しました。");
	     	}
	     }
	   }

	    public ItemBean findByPrimaryKey(int key) throws DAOException{
	    	if(con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
			try {
	     		String sql = "SELECT * FROM item WHERE code = ?";
	     		st = con.prepareStatement(sql);
	     		st.setInt(1, key);
	     		rs = st.executeQuery();

	     		if(rs.next()) {
	     			 int code = rs.getInt("code");
	     			 String name = rs.getString("name");
	     			 int price = rs.getInt("price");
	     			 String quantity = rs.getString("quantity")
	     			 ItemBean bean = new ItemBean(code, name, price);
	     			return bean;
	     		}else {
	     			return null;
	     		}
	     	} catch (Exception e) {
	 			throw new DAOException("レコードの取得に失敗しました。");
	     	} finally {
	     		try {
	     		if (rs != null) rs.close();
	     		if (st != null) st.close();
	     			close();
	     		}catch(Exception e) {
	     		throw new DAOException("リソースの開放に失敗しました。");
	     	}
	     }
	   }

	public int changeTextbook(String title, String author, int category, String status, int price, String info, int userId )
	throws DAOException{

		System.out.println(status);

		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "UPDATE textbooks SET(?, ?, ?, ?, ?, ?, ?)";
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
