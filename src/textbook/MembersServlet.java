package textbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MembersServlet
 */
@WebServlet("/MembersServlet")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDAO dao = null;
		HttpSession session = null;

		try {
			dao = new MembersDAO();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");

		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/newlogin.jsp");
			} else if (action.equals("login")) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				MembersBean bean = dao.loginMember(email, password);
				if (bean != null) {
					session = request.getSession();
					session.setAttribute("isLogin", "true");
					session.setAttribute("membean", bean);
					gotoPage(request, response, "/main-input.jsp");
				} else {
					request.setAttribute("message", "会員情報が登録されていないか、入力された情報が異なります。");
					gotoPage(request, response, "/errInternal.jsp");
				}
			}else if (action.equals("setinfo")) {
				String last_name = request.getParameter("last_name");
				String first_name = request.getParameter("first_name");
				String postal = request.getParameter("postal");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String password = request.getParameter("password");
				String passadd = request.getParameter("passadd");

				if (passadd.equals(password)) {
					MembersBean bean = new MembersBean(last_name, first_name, postal, address, tel, email, year, month, day, password);
					dao = new MembersDAO();
					dao.newMembers(bean);
					request.setAttribute("message", "登録できました!");
					gotoPage(request, response, "/newmembermessage.jsp");
				} else {
					request.setAttribute("message", "入力されたパスワードが確認用パスワードと異なります");
					gotoPage(request, response, "/errInternal.jsp");
				}

			} else if (action.equals("change")) {
				session = request.getSession(false);
				String last_name = request.getParameter("last_name");
				String first_name = request.getParameter("first_name");
				String postal = request.getParameter("postal");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String password = request.getParameter("password");
				String passadd = request.getParameter("passadd");

				if (year.equals("1900") && month.equals("1") && day.equals("1")) {
					request.setAttribute("message", "生年月日がデフォルトのまま変更されていません。");
					gotoPage(request, response, "/errInternal.jsp");
				} else {
					if (passadd.equals(password)) {
					    MembersBean bean = (MembersBean) session.getAttribute("membean");
					    bean.setLast_name(last_name);
					    bean.setFirst_name(first_name);
					    bean.setPostal(postal);
					    bean.setAddress(address);
					    bean.setTel(tel);
					    bean.setEmail(email);
					    bean.setYear(year);
					    bean.setMonth(month);
					    bean.setDay(day);
					    bean.setPassword(password);

					    dao = new MembersDAO();
						dao.changeMembers(bean);
						request.setAttribute("message", "変更できました!");
						gotoPage(request, response, "/memch-message.jsp");
					} else {
						request.setAttribute("message", "入力されたパスワードが確認用パスワードと異なります");
						gotoPage(request, response, "/errInternal.jsp");
					}
				}

			} else if (action.equals("delete")) {
				    session = request.getSession(false);
				    MembersBean bean = (MembersBean) session.getAttribute("membean");
					dao = new MembersDAO();
					dao.deleteMembers(bean);
					request.setAttribute("message", "退会しました。<br>ご利用ありがとうございました。");
					gotoPage(request, response, "/Login.html");

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

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException, IOException {
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
