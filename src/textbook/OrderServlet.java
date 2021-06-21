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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			List<TextbookBean> list;
			OrderDAO order = new OrderDAO();

			HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
				return;
			}

			String action =request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("purchase")) {
				list = (List<TextbookBean>) session.getAttribute("cart");
				MembersBean member = (MembersBean)session.getAttribute("membean");
				gotoPage(request, response, "/purchase-procedure.jsp");
			} else if(action.equals("order")) {
				list = (List<TextbookBean>) session.getAttribute("cart");
				MembersBean member = (MembersBean)session.getAttribute("membean");
				if(member == null) {
					request.setAttribute("message", "正しく操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
				}
				for (TextbookBean b : list) {
					order.deleteordered(b.getId());
				}
				session.removeAttribute("cart");
				gotoPage(request, response, "/Order.jsp");

			}else if(action.equals("deletetext")){
				session = request.getSession(false);
				if(session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
					return;
				}
				int id = Integer.parseInt(request.getParameter("dtext"));
				list = (List<TextbookBean>) session.getAttribute("cart");
				list.remove(id);
				session.setAttribute("cart", list);
				gotoPage(request, response, "/main-input.jsp");

			}else{
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
			}


		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}


	private void gotoPage(HttpServletRequest request,
		HttpServletResponse response, String page) throws ServletException,
		IOException {
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
