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


	    public TextbookBean findMyTextbook() throws DAOException{
	    	if(con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
	    	TextbookBean bean = new TextbookBean();
	    	MembersBean beans = new MembersBean();
			try {
	     		String sql = "SELECT * FROM textbooks WHERE user_id = ?";
	     		st = con.prepareStatement(sql);
	     		st.setInt(1, beans.getId());
	     		rs = st.executeQuery();
	     		while (rs.next()) {
					 String title = rs.getString("title");
					 String author = rs.getString("author");
					 int category =Integer.parseInt(rs.getString("category"));
					 int price =Integer.parseInt(rs.getString("price"));
					 String info = rs.getString("info");
					 String status = rs.getString("status");

					 bean = new TextbookBean(title, author, category, status, price, info);
	     		}
	     			return bean;
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

	    public List<TextbookBean> findAll(String title) throws DAOException {
			if (con == null)
			getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;

		try {
			String sql ="select * from textbooks where title like ?";
			st=con.prepareStatement(sql);
			st.setString(1, "%" + title +"%");
			rs = st.executeQuery();

			List<TextbookBean> list = new ArrayList<TextbookBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				title = rs.getString("title");
				String author = rs.getString("author");
				int category = rs.getInt("category");
				String status = rs.getString("status");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int userId=rs.getInt("user_id");

				    TextbookBean bean = new TextbookBean(id, title, author,category,status,price, info, userId);
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

	    public TextbookBean showAllTextbooks() throws DAOException{
	    	if(con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
	    	TextbookBean bean = new TextbookBean();
			try {
	     		String sql = "SELECT * FROM textbooks";
	     		st = con.prepareStatement(sql);
	     		rs = st.executeQuery();
	     		while (rs.next()) {
					 String title = rs.getString("title");
					 String author = rs.getString("author");
					 int category =rs.getInt("category");
					 int price =rs.getInt("price");
					 String info = rs.getString("info");
					 String status = rs.getString("status");
					 int userid = rs.getInt("user_id");

					 bean = new TextbookBean(title, author, category, status, price, info, userid);
	     		}
	     			return bean;
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

	public int changeTextbook(TextbookBean bean)
	throws DAOException{
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "UPDATE textbooks SET title=?, author=?, category=?, status=?, price=?, info=?";
			st = con.prepareStatement(sql);

			st.setString(1, bean.getTitle());
			st.setString(2, bean.getAuthor());
			st.setInt(3, bean.getCategory());
			st.setString(4, bean.getStatus());
			st.setInt(5, bean.getPrice());
			st.setString(6, bean.getInfo());

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


	public int deletetextbook(int id) throws DAOException{

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
