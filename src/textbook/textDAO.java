package textbook;

import java.sql.Connection;

public class textbookDAO {
	private Connection con;

	public textbookDAO() throws DAOException{
		getConnection();
	}

	public List<TextBookBean> findAll() throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql ="select * from TextBook where title like ?";
			st=con.prepareStatement(sql)
			st.setString(1, "%" + title +"%");
			while (ra.next()) {
				System.out.println
			}
		}
	}

