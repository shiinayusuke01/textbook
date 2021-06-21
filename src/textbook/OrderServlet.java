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
		request.setCharacterEncoding("UTF-8");
		List<TextbookBean> list;
		HttpSession session = request.getSession(false);
		String pay = request.getParameter("pay");

		String selectedPay;
		if(pay == null){
			selectedPay = "選択されていません。";
		}else {
			switch(pay){
				case "card":
					selectedPay = "クレジットカード";
					break;
				case "debit":
					selectedPay = "デビットカード";
					break;
				case "cash":
					selectedPay = "現金";
					break;
				default:
					selectedPay = "???";
					break;
			}

		if(session == null) {
			request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}

		list = (List<TextbookBean>) session.getAttribute("cart");
		if(list == null) {
			request.setAttribute("message", "正しく操作してください。");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}

		try {
			String action =request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("input_customer")) {
				gotoPage(request, response, "/purchase-procedure.jsp");
			}else if(action.equals("confirm")) {
				session = request.getSession(false);
				MembersBean bean = (MembersBean) request.getAttribute("membean");
				session.setAttribute("member", bean);
				gotoPage(request, response, "/purchase-procedure.jsp");

			}else if(action.equals("order")){
				MembersBean member = (MembersBean)session.getAttribute("members");
				if(member == null) {
					request.setAttribute("message", "正しく操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
				}

			OrderDAO order = new OrderDAO();
			int orderNumber = order.saveOrder(member, list);
			session.removeAttribute("cart");
			session.removeAttribute("members");
			request.setAttribute("orderNumber", Integer.valueOf(orderNumber));
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
