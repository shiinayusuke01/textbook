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

	PreparedStatement st=null;
	ResultSet rs=null;
	try{
		String sql ="SELECT *FROM textbooks";

		st.con.prepareStatement(sql);
		rs=st.executeQuery();
		List<ItemBean>list=new ArrayList<ItemBean>();
		while(rs.next()) {
			String title=rs.getString("title");
			String author=rs.getString("author");
			int price=rs.getInt("price");
			String status=rs.getString("status");
			String quantity=rs.getString("quantity");
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

		String url="jdbc:postgresql:sample student";
		String user="student";
		String pass="humitu";
				con=DriverManager.getConnection(url,user,pass);
	}catch(Exception e) {
		e.printStackTrace();
		throw new DAOException("接続できません。");
		}
	}
private void close() throws SQLException{
	if(con !=null) {
		con.close();
		con=null;
	}
}


}