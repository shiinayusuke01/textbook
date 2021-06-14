package la.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();

		String action =request.getParameter("action");
		if(action.equals("login")) {

		String name = request.getParameter("name");
		String passWord=request.getParameter("pw");

		//ここでSQLに問い合わせて入力した内容と合っているか確認(DAO）//

		if(name.equals(USER) && passWord.equals(PASS)){

			HttpSession session=request.getSession();
			session.setAttribute("islogin", "true");
			out.println("<html><head>Login1<title>");
			out.println("<h1>ログインありがとうございます。");
			out.println("</body><html>");
		}else {
			out.println("<html><head>Login1<title>");
			out.println("<h1>メールアドレスまたはパスワードが違います。");
			out.println("</body><html>");
		}
		}else if(action.equals("logout")){
			HttpSession session=request.getSession(false);
			if(session !=null);

			session.invalidate();
			out.println("<html><head>Login1<title>");
			out.println("<h1>ログアウトしました。またのお越しをお待ちしております。");
			out.println("</body><html>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
