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
			list = (List<TextbookBean>) session.getAttribute("cart");
			MembersBean member = (MembersBean)session.getAttribute("membean");
			if (action == null || action.length() == 0 || action.equals("purchase")) {
				gotoPage(request, response, "/purchase-procedure.jsp");
			} else if(action.equals("delete2")){
				session = request.getSession(false);
				if(session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
					return;
				}
				int id = Integer.parseInt(request.getParameter("textsid2"));
				list = (List<TextbookBean>) session.getAttribute("cart");
				for (int i =0; i < list.size(); i++) {
					if (list.get(i).getId() == id) {
						list.remove(i);
						break;
					}
				}
				session.setAttribute("cart", list);
				if (list == null || list.size() == 0) {
					gotoPage(request, response, "/cart.jsp");
				} else {
					gotoPage(request, response, "/purchase-procedure.jsp");
				}
			} else if(action.equals("order")) {
				if(member == null) {
					request.setAttribute("message", "正しく操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
				}
				for (TextbookBean b : list) {
					order.deleteordered(b.getId());
				}
				session.removeAttribute("cart");
				gotoPage(request, response, "/Order.jsp");

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
