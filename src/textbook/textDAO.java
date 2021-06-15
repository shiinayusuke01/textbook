package textbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class textDAO {
	private Connection con;

	public textDAO() throws DAOException{
		getConnection();
	}

	public List<TextbookBean> findAll() throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql ="select * from TextBook where title like ?";
			st=con.prepareStatement(sql);
			st.setString(1, "%" + title +"%");
			while (ra.next()) {
				System.out.println
			}
		}
	}