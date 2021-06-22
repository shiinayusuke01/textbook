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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextBookDAO dao = null;
		List<TextbookBean> list;

		try {
			dao = new TextBookDAO();
		} catch (DAOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try {
			String action =request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/cart.jsp");
			} else if(action.equals("add")) {
				int id = Integer.parseInt(request.getParameter("text-id"));
				HttpSession session = request.getSession(false);
				list = (List<TextbookBean>) session.getAttribute("cart");
				if (list == null) {
					list = new ArrayList<TextbookBean>();
				}
				for (int i =0; i < list.size(); i++) {
					if (list.get(i).getId() == id) {
						request.setAttribute("message", "選択した教科書はすでにカートに追加されています");
						gotoPage(request, response, "/memch-message.jsp");
						return;
					}
				}

				TextbookBean bean = (TextbookBean) dao.findByPrimaryKey(id);
				list.add(bean);
				session.setAttribute("cart", list);
				gotoPage(request, response, "/cart.jsp");

			} else if(action.equals("addtext")) {
				int id = Integer.parseInt(request.getParameter("textid"));
				HttpSession session = request.getSession(false);
				list = (List<TextbookBean>) session.getAttribute("cart");
				if (list == null) {
					list = new ArrayList<TextbookBean>();
				}
				for (int i =0; i < list.size(); i++) {
					if (list.get(i).getId() == id) {
						request.setAttribute("message", "選択した教科書はすでにカートに追加されています");
						gotoPage(request, response, "/memch-message.jsp");
						return;
					}
				}
				TextbookBean bean = (TextbookBean) dao.findByPrimaryKey(id);
				list.add(bean);
				session.setAttribute("cart", list);
				gotoPage(request, response, "/cart.jsp");
			} else if(action.equals("delete")){
				HttpSession session = request.getSession(false);
				if(session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
					gotoPage(request, response, "/errInternal.jsp");
					return;
				}
				int id = Integer.parseInt(request.getParameter("textsid"));
				list = (List<TextbookBean>) session.getAttribute("cart");
				for (int i =0; i < list.size(); i++) {
					if (list.get(i).getId() == id) {
						list.remove(i);
						break;
					}
				}
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
			HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
