package textbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowItenServlet
 */
@WebServlet("/ShowTextbookServlet")
public class ShowTextbookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String action = request.getParameter("action");

			if(action==null||action.length()==0||action.equals("top")) {
				gotoPage(request,response, "/main-input.jsp");
			}else if (action.equals("list")) {
				int categoryCode=Integer.parseInt(request.getParameter("code"));
				ItemDAO dao=new ItemDAO();
				List<ItemBean>list=dao.findByCategory（categoryCode);

				request.setAttribute("items",list);
				gotoPage(request,response,"list.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request,response,"/errInput.jsp");
			}

		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"errInput.jsp");
		}
	}
public void init() throws ServletException{
	try {
		ItemDAO dao=new ItemDAO();
		List<CategoryBean>list=dao.findAllCategory();
		getServletContext().setAttribute("categories", list);
	}catch(DAOExceptbion e) {
		e.printStackTrace();
		throw new ServletException();
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
