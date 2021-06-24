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
 * Servlet implementation class DeleteInquiryServlet
 */
@WebServlet("/DeleteInquiryServlet")
public class DeleteInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int inquiryId = Integer.parseInt(request.getParameter("inquiry_id"));
		System.out.println(inquiryId);
		try {
			String action = request.getParameter("action");
			InquiryDAO dao = new InquiryDAO();
			List<InquiryBean> inquirybeans = dao.findAll();

			if (action.equals("delete")) {
			dao.deleteInquiryById(inquiryId);
			}
			request.setAttribute("inquirybeans", inquirybeans);
			gotoPage(request, response, "ad-main-input.jsp");


		}catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
