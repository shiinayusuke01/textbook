package textbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowMyTextbook
 */
@WebServlet("/ShowMyTextbook")
public class ShowMyTextbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyTextbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MembersBean bean = (MembersBean) session.getAttribute("membean");
		String firstName = bean.getFirst_name();
		int userId = bean.getId();

		try {
			TextBookDAO dao = new TextBookDAO();
			List<TextbookBean> list = dao.selectByUserId(userId);
			request.setAttribute("textbooks", list);
			request.setAttribute("first_name", firstName);
		}catch (DAOException e) {
			e.printStackTrace();
		}
		gotoPage(request, response, "my-textbook.jsp");
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
