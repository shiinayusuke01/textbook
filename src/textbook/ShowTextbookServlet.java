package textbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import textbook.ItemBean;
import textbook.ItemDAO;
import textbook.DAOException;

@WebServlet("/ShowTextbookServlet")
public class ShowTextbookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		ItemDAO dao=new ItemDAO();
		List<ItemBean>list=dao.findAll();
	  request.setAttribute("items", list);
	  RequestDispatcher rd=request.getRequestDispatcher("/cart.jsp");
	  rd.forward(request,response);
	}catch(DAOException e) {
		e.printStackTrace();
		request.setAttribute("message", "内部エラーが発生しました。");
		RequestDispatcher rd=request.getRequestDispatcher("errInternal.jsp");
		rd.forward(request,response);
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
