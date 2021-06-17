package textbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdMainPageServlet
 */
@WebServlet("/AdMainPageServlet")
public class AdMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdMainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDAO dao = null;

		try {
			dao = new MembersDAO();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");

		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/newlogin.jsp");
			} else if (action.equals("memsearch")) {
				String searchname = request.getParameter("searchname");
				List<MembersBean> list = dao.findAllMembers(searchname);
				request.setAttribute("show", list);
				gotoPage(request, response, "/ad-main-input.jsp");
			} else if (action.equals("memdelete")) {
				int mem_id = Integer.parseInt(request.getParameter("mem_id"));
				dao.deleteMembers(mem_id);
				gotoPage(request, response, "/ad-main-input.jsp");
				}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException, IOException {
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
