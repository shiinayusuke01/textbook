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

public List<CategoryBean> findAllCategory() throws DAOException{
	if(con == null)
		getConnection();

	PreparedStatement st=null;
	ResultSet rs=null;
	try{
		String sql ="SELECT *FROM category ORDER BY code";

		st=con.prepareStatement(sql);
		rs=st.executeQuery();
		List<CategoryBean>list=new ArrayList<CategoryBean>();
		while(rs.next()) {
			int code=rs.getInt("code");
			String name=rs.getString("name");
			CategoryBean bean=new CategoryBean(code,name);
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
public List<ItemBean>findByCategory(int categoryCode)
		throws DAOException{
	if(con == null)
		getConnection();

	PreparedStatement st=null;
	ResultSet rs=null;
	try{
		String sql ="SELECT *FROM item WHERE category_code=? ORDER BY code";

		st=con.prepareStatement(sql);
		st.setInt(1, categoryCode);

		rs=st.executeQuery();
		List<ItemBean>list=new ArrayList<ItemBean>();
		while(rs.next()) {
			int code=rs.getInt("code");
			String name=rs.getString("name");
			int price=rs.getInt("price");
			ItemBean bean=new ItemBean(code,name,price);
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
public ItemBean findByPrimarykey(int key)
		throws DAOException{
	if(con == null)
		getConnection();

	PreparedStatement st=null;
	ResultSet rs=null;
	try{
		String sql ="SELECT *FROM item WHERE code=?";

		st=con.prepareStatement(sql);
		st.setInt(1, key);

		rs=st.executeQuery();
		if(rs.next()) {
			int code=rs.getInt("code");
			String name=rs.getString("name");
			int price=rs.getInt("price");
			ItemBean bean=new ItemBean(code,name,price);
			return bean;
		}else {
			return null;
		}
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
		Class.forName("org.postgressql.Driver");

		String url="jdbc:postgresql:sample";
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