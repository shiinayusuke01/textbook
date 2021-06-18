package textbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
private Connection con;

public ItemDAO() throws DAOException{
	getConnection();

}

public List<ItemBean> findAll() throws DAOException{
	if(con == null)
		getConnection();

	PreparedStatement st = null;
	ResultSet rs=null;
	try{
		String sql ="SELECT * FROM textbooks";

		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		List<ItemBean>list=new ArrayList<ItemBean>();
		while(rs.next()) {
			String title=rs.getString("title");
			String author=rs.getString("author");
			int price=rs.getInt("price");
			String status=rs.getString("status");
			int quantity=rs.getInt("quantity");
			ItemBean bean=new ItemBean(title,author, price, status, quantity);
			list.add(bean);
		}
		return list;
	}catch(Exception e){
	e.printStackTrace();
	throw new DAOException("レコードの取得に失敗しました");
	}finally {
		try {
			if(rs !=null) rs.close();
			if(st !=null) st.close();
		close();
		}catch(Exception e) {
			throw new DAOException("リソースの開放に失敗しました");

	}

}
}

private void getConnection()throws DAOException{
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
private void close() throws SQLException{
	if(con !=null) {
		con.close();
		con=null;
	}
}


}