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
			String sql = "INSERT INTO textbooks(title, author, category, status, price, info, user_id, stock) VALUES(?, ?, ?, ?, ?, ?, ?, 1)";
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


	  public TextbookBean findByPrimaryKey(int code) throws DAOException{
	    	if (con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
	    	try {

	    		String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id where t.id = ? order by t.category, t.title, t.price";
	    		st = con.prepareStatement(sql);
	    		st.setInt(1, code);
	    		rs = st.executeQuery();

	    		if (rs.next()) {
	    		 int id = rs.getInt("id");
	    		 String title = rs.getString("title");
				 String author = rs.getString("author");
				 int category =rs.getInt("category");
				 String categoryname =rs.getString("categoryname");
				 int price =Integer.parseInt(rs.getString("price"));
				 String info = rs.getString("info");
				 String status = rs.getString("status");
				 int userid = rs.getInt("user_id");
				 TextbookBean bean = new TextbookBean(id, title, category, author, status, price, info, userid, categoryname);
	    		 return bean;
	    		} else {
	    			return null;
	    		}
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


	    public List<TextbookBean> findMyTextbook(MembersBean beans) throws DAOException{
	    	if(con == null)
	    		getConnection();

	    	PreparedStatement st = null;
	    	ResultSet rs = null;
	    	TextbookBean bean = new TextbookBean();
	    	beans = new MembersBean();
			try {
	     		String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id WHERE t.user_id = ? order by t.category, t.title, t.price";
	     		st = con.prepareStatement(sql);
	     		st.setInt(1, beans.getId());
	     		rs = st.executeQuery();
	     		List<TextbookBean> list = new ArrayList<>();
	     		while (rs.next()) {
					 String title = rs.getString("title");
					 String author = rs.getString("author");
					 int category = rs.getInt("category");
					 String categoryname =rs.getString("categoryname");
					 int price =Integer.parseInt(rs.getString("price"));
					 String info = rs.getString("info");
					 String status = rs.getString("status");
					 int userid = rs.getInt("user_id");

					 bean = new TextbookBean(title, category, author, status, price, info, userid, categoryname);
					 list.add(bean);
	     		}
	     			return list;
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
			String sql ="select * from textbooks t JOIN categories c on t.category = c.id where t.title like ? AND t.stock=1 order by t.category, t.title, t.price";
			st=con.prepareStatement(sql);
			st.setString(1, "%" + title +"%");
			rs = st.executeQuery();

			List<TextbookBean> list = new ArrayList<TextbookBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				title = rs.getString("title");
				String author = rs.getString("author");
				 int category = rs.getInt("category");
				String categoryname = rs.getString("categoryname");
				String status = rs.getString("status");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int userId=rs.getInt("user_id");
				int stock = rs.getInt("stock");

				    TextbookBean bean = new TextbookBean(id, title,category,author,status,price, info, userId, stock, categoryname);
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

	    public List<TextbookBean> findByAuthor(String author) throws DAOException {
			if (con == null)
			getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;

		try {
			String sql ="select * from textbooks t JOIN categories c on t.category = c.id where t.author like ? AND t.stock=1 order by t.category, t.title, t.price";
			st=con.prepareStatement(sql);
			st.setString(1, "%" + author +"%");
			rs = st.executeQuery();

			List<TextbookBean> list = new ArrayList<TextbookBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				author = rs.getString("author");
				 int category = rs.getInt("category");
				String categoryname = rs.getString("categoryname");
				String status = rs.getString("status");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int userId=rs.getInt("user_id");
				int stock = rs.getInt("stock");

				    TextbookBean bean = new TextbookBean(id, title,category,author,status,price, info, userId, stock, categoryname);
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

	    public List<TextbookBean> findByCategory(int cate) throws DAOException {
			if (con == null)
			getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;

		try {
			String sql ="select * from textbooks t JOIN categories c on t.category = c.id where t.category=? AND t.stock=1 order by t.category, t.title, t.price";
			st=con.prepareStatement(sql);
			st.setInt(1, cate);
			rs = st.executeQuery();

			List<TextbookBean> list = new ArrayList<TextbookBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int category = rs.getInt("category");
				String status = rs.getString("status");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int userId=rs.getInt("user_id");
				int stock = rs.getInt("stock");
				String categoryname = rs.getString("categoryname");


				    TextbookBean bean = new TextbookBean(id, title, category,author,status,price, info, userId, stock, categoryname);
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



	public int changeTextbook(TextbookBean bean) throws DAOException{
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "UPDATE textbooks SET title=?, category=?, author=?, status=?, price=?, info=?, user_id=?, stock=1 WHERE id=? ";
			st = con.prepareStatement(sql);

			st.setString(1, bean.getTitle());
			st.setInt(2, bean.getCategory());
			st.setString(3, bean.getAuthor());
			st.setString(4, bean.getStatus());
			st.setInt(5, bean.getPrice());
			st.setString(6, bean.getInfo());
			st.setInt(7, bean.getUserId());
			st.setInt(8, bean.getId());

			// SQLの実行
			int rows = st.executeUpdate();

			// カテゴリ一覧をListとして返す
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
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

	public List<TextbookBean> showAllTextbooks() throws DAOException{
    	if(con == null)
    		getConnection();

    	PreparedStatement st = null;
    	ResultSet rs = null;
    	TextbookBean bean = new TextbookBean();
		try {
     		String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id where t.stock=1 order by t.category, t.title, t.price";
     		st = con.prepareStatement(sql);
     		rs = st.executeQuery();
     		List<TextbookBean> list = new ArrayList<TextbookBean>();
     		while (rs.next()) {
				 int id = rs.getInt("id");
				 String title = rs.getString("title");
				 String author = rs.getString("author");
				 int category = rs.getInt("category");
				 String categoryname =rs.getString("categoryname");
				 int price =rs.getInt("price");
				 String info = rs.getString("info");
				 String status = rs.getString("status");
				 int userid = rs.getInt("user_id");
				 int stock = rs.getInt("stock");

				 bean = new TextbookBean(id, title, category, author, status, price, info, userid, stock, categoryname);
				 list.add(bean);
     		}
     			return list;
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


	public int deleteTextbook(int id) throws DAOException{

		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {

			// SQL文の作成
			String sql = "DELETE FROM textbooks where id=?";
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
    public List<TextbookBean> selectByUserId(int userId)throws DAOException{
        if(con == null)
        getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
        String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id WHERE t.user_id = ? order by t.category, t.title, t.price";
        st = con.prepareStatement(sql);
        st.setInt(1, userId);
        rs = st.executeQuery();


        List<TextbookBean> list = new ArrayList<TextbookBean>();
        while(rs.next()) {
        		int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int category = rs.getInt("category");
                String status = rs.getString("status");
                int price = rs.getInt("price");
                String info = rs.getString("info");
				int stock = rs.getInt("stock");
				String categoryname = rs.getString("categoryname");


                TextbookBean bean = new TextbookBean(id, title, category, author, status, price, info, userId, stock, categoryname);
                list.add(bean);
        }
        return list;
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
    public List<TextbookBean> selectById(int id)throws DAOException{
        System.out.println("id :" + id);
    	if(con == null)
        	getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
        String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id WHERE t.user_id = ? order by t.category, t.title, t.price";
        st = con.prepareStatement(sql);
        st.setInt(1, id);
        rs = st.executeQuery();
        List<TextbookBean> list = new ArrayList<TextbookBean>();


        while (rs.next()) {
        String title = rs.getString("title");
        String author = rs.getString("author");
        int category = rs.getInt("category");
        String status = rs.getString("status");
        int price = rs.getInt("price");
        String info = rs.getString("info");
        int userId = rs.getInt("user_id");
		int stock = rs.getInt("stock");
		String categoryname = rs.getString("categoryname");
        TextbookBean bean = new TextbookBean(id, title, category, author, status, price, info, userId, stock, categoryname);
        list.add(bean);
        }
        return list;
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
    public TextbookBean selectbyid(int id)throws DAOException{
        System.out.println("id :" + id);
    	if(con == null)
        	getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
        String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id WHERE t.id = ? order by t.category, t.title, t.price";
        st = con.prepareStatement(sql);
        st.setInt(1, id);
        rs = st.executeQuery();


        rs.next();
        String title = rs.getString("title");
        String author = rs.getString("author");
        int category = rs.getInt("category");
        String status = rs.getString("status");
        int price = rs.getInt("price");
        String info = rs.getString("info");
        int userId = rs.getInt("user_id");
		int stock = rs.getInt("stock");
		String categoryname = rs.getString("categoryname");
        TextbookBean bean = new TextbookBean(id, title, category, author, status, price, info, userId, stock, categoryname);
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
    public List<TextbookBean> findByBuyer(int buyer)throws DAOException{
    	if(con == null)
        	getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
        String sql = "SELECT * FROM textbooks t JOIN categories c on t.category = c.id WHERE t.buyer = ? order by t.category, t.title, t.price";
        st = con.prepareStatement(sql);
        st.setInt(1, buyer);
        rs = st.executeQuery();

        List<TextbookBean> list = new ArrayList<TextbookBean>();
        while(rs.next()) {
        	int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            int category = rs.getInt("category");
            String status = rs.getString("status");
            int price = rs.getInt("price");
            String info = rs.getString("info");
            int userId = rs.getInt("user_id");
    		int stock = rs.getInt("stock");
    		String categoryname = rs.getString("categoryname");

            TextbookBean bean = new TextbookBean(id, title, category, author, status, price, info, userId, stock, categoryname);
            list.add(bean);
        }

        return list;
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


	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
