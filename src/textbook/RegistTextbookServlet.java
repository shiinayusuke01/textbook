package textbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistTextbookServlet
 */
@WebServlet("/RegistTextbookServlet")
public class RegistTextbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistTextbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		MembersBean bean = (MembersBean) session.getAttribute("membean");
		int userId = bean.getId();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int category = Integer.parseInt(request.getParameter("category"));
		String status = request.getParameter("status");
		int price = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		}catch (NumberFormatException e) {
			request.setAttribute("errmsg", "売値は半角数字で入力してください");
			gotoPage(request, response, "regist-textbook.jsp");
		}


		String info = request.getParameter("info");
//		System.out.println(userId);
//		System.out.println(title);
//		System.out.println(author);
//		System.out.println(category);
//		System.out.println(status);
//		System.out.println(info);

		String ti = escapeHTML(title);
		String au = escapeHTML(author);
		String st = escapeHTML(status);
		String in = escapeHTML(info);

		PrintWriter out = response.getWriter();
		out.print(title + category);

		try {
			TextBookDAO dao = new TextBookDAO();
			dao.newTextbook(ti, au, category, st, price, in, userId);
		}catch (DAOException e) {
			e.printStackTrace();
		}


		gotoPage(request, response, "ShowMyTextbook?inserted_textbook=" + ti);
	}

	public static String escapeHTML(String a) {
		   if (a == null) return "";
		   a = a.replaceAll("&", "");
		   a = a.replaceAll("<", "");
		   a = a.replaceAll(">", "");
		   a = a.replaceAll("\"", "");
		   a = a.replaceAll("'", "");
		   return a;
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
