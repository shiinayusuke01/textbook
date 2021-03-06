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
					int id = bean.getId();
					String la = escapeHTML(bean.getLast_name());
					String fi = escapeHTML(bean.getFirst_name());
					String po = escapeHTML(bean.getPostal());
					String ad = escapeHTML(bean.getAddress());
					String te = escapeHTML(bean.getTel());
					String em = escapeHTML(bean.getEmail());
					String birthday = bean.getBirthday();
					String pa = escapeHTML(bean.getPassword());
					bean = new MembersBean(id, la, fi, po, ad, te, em, birthday, pa);
					if (bean.getId() == 0) {
						session = request.getSession();
						session.setAttribute("isLogin", "true");
						session.setAttribute("membean", bean);
						gotoPage(request, response, "/ad-main-input.jsp");
					} else {
						session = request.getSession();
						session.setAttribute("isLogin", "true");
						session.setAttribute("membean", bean);
						gotoPage(request, response, "/MainPageServlet?action=list");
					}
				} else {
					request.setAttribute("message", "???????????????????????????????????????????????????????????????????????????????????????");
					gotoPage(request, response, "/errInternal.jsp");
				}

			} else if (action.equals("setinfo")) {
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
				List<String> list = dao.email();
				String judge = dao.emailcheck(email, list);
				if (last_name == null || last_name.length() <= 0 || first_name == null || first_name.length() <= 0 || postal == null || postal.length() <= 0|| address == null || address.length() <= 0|| tel == null || tel.length() <= 0 || email == null || email.length() <= 0|| password == null || password.length() <= 0) {
					request.setAttribute("message", "????????????????????????????????????????????????");
					gotoPage(request, response, "/errInternal.jsp");
				} else if (judge.equals("out")) {
					request.setAttribute("message", "???????????????????????????????????????????????????????????????????????????<br>??????????????????????????????????????????????????????");
					gotoPage(request, response, "/newmembermessage.jsp");
				} else {
					if (passadd.equals(password)) {

						String la = escapeHTML(last_name);
						String fi = escapeHTML(first_name);
						String po = escapeHTML(postal);
						String ad = escapeHTML(address);
						String te = escapeHTML(tel);
						String em = escapeHTML(email);
						String pa = escapeHTML(password);

						MembersBean bean = new MembersBean(la, fi, po, ad, te, em, year, month, day, pa);
						dao = new MembersDAO();
						dao.newMembers(bean);
						request.setAttribute("message", "?????????????????????!");
						gotoPage(request, response, "/newmembermessage.jsp");
					} else {
						request.setAttribute("message", "???????????????????????????????????????????????????????????????????????????");
						gotoPage(request, response, "/errInternal.jsp");
					}
				}

			} else if (action.equals("change")) {
				session = request.getSession(false);
				if (session == null) {
					gotoPage(request, response, "/Login.html");
				}
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

				if (last_name == null || last_name.length() <= 0 || first_name == null || first_name.length() <= 0 || postal == null || postal.length() <= 0|| address == null || address.length() <= 0|| tel == null || tel.length() <= 0 || email == null || email.length() <= 0|| password == null || password.length() <= 0) {
					request.setAttribute("message", "????????????????????????????????????????????????");
					gotoPage(request, response, "/errInternal.jsp");
				} else if (year.equals("1900") && month.equals("1") && day.equals("1")) {
					request.setAttribute("message", "?????????????????????????????????????????????????????????????????????<br>???????????????????????????????????????????????????");
					gotoPage(request, response, "/memch-message.jsp");
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


						    int id = bean.getId();
							String la = escapeHTML(bean.getLast_name());
							String fi = escapeHTML(bean.getFirst_name());
							String po = escapeHTML(bean.getPostal());
							String ad = escapeHTML(bean.getAddress());
							String te = escapeHTML(bean.getTel());
							String em = escapeHTML(bean.getEmail());
							String pa = escapeHTML(bean.getPassword());


							bean = new MembersBean(id, la, fi, po, ad, te, em, year, month, day, pa);
						    dao = new MembersDAO();
							dao.changeMembers(bean);
							request.setAttribute("membean", bean);
							request.setAttribute("message", "?????????????????????!");
							gotoPage(request, response, "/memch-message.jsp");
						} else {
							request.setAttribute("message", "???????????????????????????????????????????????????????????????????????????");
							gotoPage(request, response, "/errInternal.jsp");
						}
					}


			} else if (action.equals("delete")) {
				    session = request.getSession(false);
				    if (session == null) {
						gotoPage(request, response, "/Login.html");
					}
				    MembersBean bean = (MembersBean) session.getAttribute("membean");
					dao = new MembersDAO();
					dao.deleteMembers(bean.getId());
					request.setAttribute("message", "?????????????????????<br>?????????????????????????????????????????????");
					gotoPage(request, response, "/newmembermessage.jsp");

			} else if (action.equals("logout")) {
				session = request.getSession(false);
				if (session != null) {
					session.invalidate();
					request.setAttribute("message", "??????????????????????????????");
					gotoPage(request, response, "/newmembermessage.jsp");
				}

			} else {
				request.setAttribute("message", "????????????????????????????????????");
				gotoPage(request, response, "/errInternal.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "???????????????????????????????????????");
			gotoPage(request, response, "/errInternal.jsp");
		}
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
