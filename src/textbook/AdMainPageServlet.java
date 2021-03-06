package textbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdMainPageServlet
 */
@WebServlet("/AdMainPageServlet")
public class AdMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdMainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDAO dao = null;
		TextBookDAO tdao = null;
		InquiryDAO idao = null;

		try {
			dao = new MembersDAO();
			tdao = new TextBookDAO();
			idao = new InquiryDAO();

		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");

		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/Login.html");

			} else if (action.equals("memsearch")) {
				String searchname = request.getParameter("searchname");
				List<MembersBean> memlist = dao.findAllMembers(searchname);
				request.setAttribute("showmem", memlist);
				gotoPage(request, response, "/ad-main-input.jsp");

			} else if (action.equals("memdelete")) {
				int mem_id = Integer.parseInt(request.getParameter("mem_id"));
				dao.deleteMembers(mem_id);
				request.setAttribute("message", "ユーザーを削除しました。");
				gotoPage(request, response, "/ad-message.jsp");

			}else if (action.equals("textsearch")) {
				String searchtitle = request.getParameter("searchtitle");
				List<TextbookBean> textlist = tdao.findAll(searchtitle);
				request.setAttribute("showtext", textlist);
				gotoPage(request, response, "/ad-main-input.jsp");

			} else if (action.equals("textdelete")) {
				int text_id = Integer.parseInt(request.getParameter("text_id"));
				tdao.deleteTextbook(text_id);
				request.setAttribute("message", "教科書を削除しました。");
				gotoPage(request, response, "/ad-message.jsp");

			}else if (action.equals("inquiryshow")) {
				List<InquiryBean> list = idao.findAll();
				request.setAttribute("showinquiry", list);
				gotoPage(request, response, "/ad-main-input.jsp");

			} else if (action.equals("inquirydelete")) {
				int inquiryId = Integer.parseInt(request.getParameter("inquiry_id"));
				idao.deleteInquiryById(inquiryId);
				request.setAttribute("message", "問い合わせを削除しました。");
				gotoPage(request, response, "/ad-message.jsp");
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
