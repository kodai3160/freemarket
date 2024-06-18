package servlet;

import java.io.IOException;

import bean.LoginInfo;
import dao.loginInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//error用変数
		String error = null;
		//cmd
		String cmd = null;

		try {

			//username,password入力のパラメーターを取得
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			//loginInfoDAOをインスタンス化し、関連メソッドを呼び出す
			loginInfoDAO objDao = new loginInfoDAO();
			LoginInfo loginInfo = objDao.selectByUser(email, password);

			//０の場合ユーザー、１の場合管理者
			if (loginInfo.getLoginFlag() == 0) {
				request.getRequestDispatcher("/productList").forward(request, response);
			} else if (loginInfo.getLoginFlag() == 1) {
				request.getRequestDispatcher("/view/menu.jsp");
			} else {
				error = "入力データが間違っています。";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "menu";
		} finally {
			if (error != null) {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}
		}

	}

}
