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

		request.setCharacterEncoding("UTF-8");
		try {
			TextBookDAO	dao = new TextBookDAO();
			List<TextbookBean> list = dao.showAllTextbooks();
			request.setAttribute("showall", list);


			String action = request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("list")) {
				gotoPage(request, response, "/main-input.jsp");
			} else if (action.equals("search")){
					String searchname = request.getParameter("searchname");
					List<TextbookBean> lists = dao.findAll(searchname);
					request.setAttribute("show", lists);
					gotoPage(request, response, "/main-input.jsp");
			} else if (action.equals("searchcate")) {
				int searchcategory = Integer.parseInt(request.getParameter("category"));
				List<TextbookBean> lists = dao.findByCategory(searchcategory);
				request.setAttribute("show", lists);
				gotoPage(request, response, "/main-input.jsp");
			} else if (action.equals("searchauthor")) {
				String searchauthor = request.getParameter("authorname");
				List<TextbookBean> lists = dao.findByAuthor(searchauthor);
				request.setAttribute("show", lists);
				gotoPage(request, response, "/main-input.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
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



