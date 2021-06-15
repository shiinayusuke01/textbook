package textbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		private void getDB(HttpServletRequest request) {
			try {
					Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			    	//IPアドレスはEC2再起動の度に変わります
			        String connUrl =
			          "jdbc:sqlserver://XXX.XXX.XXX.XXX:1433;database=testdb;"
			            + "user=testuser;password=password";
			        Connection con = d.connect(connUrl, new Properties());

			        String sql = "select * from Table_2;";
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery(sql);

			        List<TextBookBean> list = new ArrayList<TextBookBean>();

			        while (rs.next()) {
			            list.add(new TextBookBean(rs.getString("text"),  rs.getString("category"), rs.getString("author"),  rs.getString("price"),
			            		rs.getString("status"), rs.getString("info")));
			        }

			        request.setAttribute("dbdata", list);

			        rs.close();
			        stmt.close();
			        con.close();
			}
			      catch (Exception e) {
			        e.printStackTrace();
			      } finally {
			      	}
			}
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
