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
			textDAO dao = new textDAO();
			List<TextbookBean> list = dao.findAll();
			//リストをJSPに送る
			request.setAttribute("textbook", list);
			RequestDispatcher rd = request.getRequestDispatcher("/main-input.jsp");
			rd.forward(request,  response);
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute(" message", " 正しいタイトルを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request,  response);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

