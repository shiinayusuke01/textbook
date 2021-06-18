package textbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistTextbook
 */
@WebServlet("/RegistTextbook")
public class RegistTextbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistTextbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = 1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int category = Integer.parseInt(request.getParameter("category"));
		String status = request.getParameter("status");
		int price = Integer.parseInt(request.getParameter("price"));
		String info = request.getParameter("info");


		PrintWriter out = response.getWriter();
		out.print(title + category);

		try {
			TextBookDAO dao = new TextBookDAO();
			dao.newTextbook(title, author, category, status, price, info, userId );
		}catch (DAOException e) {
			e.printStackTrace();
		}
		gotoPage(request, response, "form-textbook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
