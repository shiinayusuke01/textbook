package textbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeTextServlet
 */
@WebServlet("/ChangeTextServlet")
public class ChangeTextbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTextbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param change
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object change) throws ServletException, IOException {
		TextBookDAO dao = null;
		HttpSession session = null;

		try {
			dao = new TextBookDAO();
		}catch (DAOException e) {
				e.printStackTrace();
		}request.setCharacterEncoding("UTF-8");

		try {
			String action =request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("top")) {
				gotoPage(request, response, "/main-input.jsp");
			} else if(action.equals("reg")) {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int category = Integer.parseInt(request.getParameter("category"));
				String status = request.getParameter("status");
				int price = Integer.parseInt(request.getParameter("price"));
				String info = request.getParameter("info");
				int userId = Integer.parseInt(request.getParameter("userId"));
				int bean = dao.newTextbook(title, author, category, status, price, info, userId);
				session = request.getSession(true);
				if(bean == 0) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					session.setAttribute("tetbeen", bean);
					gotoPage(request, response, "/form-textbook.jsp");
			    } else {
					request.setAttribute("message", "教科書が正しく登録されていません。");
					gotoPage(request, response, "/errInternal.jsp");
				}

			}else if(action.equals("change")){
				session = request.getSession(false);
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int category = Integer.parseInt(request.getParameter("category"));
			    int price = Integer.parseInt(request.getParameter("price"));
				String info = request.getParameter("info");
				String status = request.getParameter("status");
				int userId = Integer.parseInt(request.getParameter("userId"));

				if (title == null || author == null || category == 0 || price == 0 || info == null || status == null || userId == 0) {
					request.setAttribute("message", "変更情報はすべて入力してください。");
					gotoPage(request, response, "/errInternal.jsp");
				} else {
					if (change.equals(change)) {
						TextbookBean bean = (TextbookBean) session.getAttribute("txtbean");
						bean.setTitle(title);
						bean.setAuthor(author);
						bean.setCategory(category);
						bean.setPrice(price);
						bean.setInfo(info);
						bean.setStatus(status);
						bean.setUserId(userId);

						dao = new TextBookDAO();
					    dao.changeTextbook(bean);
						request.setAttribute("message", "変更できました!");
						gotoPage(request, response, "/memch-message.jsp");
					} else {
						request.setAttribute("message", "入力された値は使用できません。");
						gotoPage(request, response, "/errInternal.jsp");
					}

				}

			} else if (action.equals("textchange")) {
				TextbookBean bean = dao.findMyTextbook();
				request.setAttribute("textbook", bean);
				gotoPage(request, response, "/textbook/regist-textbooko.jsp");
			} else if (action.equals("delete")) {
				    session = request.getSession(false);
				    TextbookBean bean = (TextbookBean) session.getAttribute("txtbean");
					dao = new TextBookDAO();
					dao.deletetextbook(bean);
					request.setAttribute("message", "登録教科書を削除しました。");
					gotoPage(request, response, "/delete-message.jsp");

			} else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
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
