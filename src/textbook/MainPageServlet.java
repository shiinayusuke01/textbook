package textbook;

import java.io.IOException;
import java.util.ArrayList;
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
	private Object textbook;

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

		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/newlogin.jsp");
			} else if (action.equals("search")) {
			String title = request.getParameter("title");
			List<TextbookBean> list = new ArrayList<TextbookBean>();
			textDAO dao = new textDAO();
			list = dao.findAll(title);
			//リストをJSPに送る
			request.setAttribute("list",  list);
			RequestDispatcher rd = request.getRequestDispatcher("/main-input.jsp");
			rd.forward(request,  response);
			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute(" message", " 正しいタイトルを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request,  response);
		}
	}



	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

