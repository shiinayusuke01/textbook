package textbook;

import java.sql.ResultSet;
import java.util.List;

public class ItemDAO {
private Connection con;

public ItemDAO()throws DAOException{
	get Connection();

}
public List<CategoryBeamn>findAllCategory()throws DAOException{
	if(con==null)
		getConnection();
	PreparedStatement st=null;
	ResultSet rs=null;
	try {
		String sql ="SELECT *FROM category ORDER BY code";

		st=con.preparedStatement(sql);
		re=st.executeQuery();
		List<CategoryBean>list=new ArrayList<CategoryBean>();
		while(rs.next()) {
			int code=rs.getInt("code");
			String name=rs.getString("name");
			CategoryBean bean=new CategoryBean(code,name);
			list.add(bean);
		}
		return list;
	}
}
}
