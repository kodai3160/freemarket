package servlet;

import java.io.IOException;

import bean.LoginInfo;
import dao.LoginInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//error用変数
		String error = null;
		String message = null;
		//オブジェクトを生成
		LoginInfo loginInfo = null;
		try {
			//email,password入力のパラメーターを取得
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			//loginInfoDAOをインスタンス化し、関連メソッドを呼び出す
			LoginInfoDAO objDao = new LoginInfoDAO();
			loginInfo = objDao.selectByUser(email, password);
			//ユーザーが存在するのか判定
			if (loginInfo.getUserId() == 0) {
				message = "入力された情報のアカウントは存在しませんでした。";
				return;
			}else {
				//ユーザーが存在する場合、セッションとクッキーに登録する
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", loginInfo);
				Cookie emailCookie = new Cookie("email", email);
				emailCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(emailCookie);
				Cookie passwordCookie = new Cookie("password", password);
				passwordCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(passwordCookie);
			}
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
		} finally {
			String forwardpath = "";
			//エラーかユーザーの有無によって遷移先を判定
			if (error != null) {
				request.setAttribute("error", error);
				forwardpath= "/view/error.jsp";
			} else if (message != null) {
				request.setAttribute("message", message);
				forwardpath= "/view/login.jsp";
			}else {
				//会員か管理者かを判定 ０の場合ユーザー、１の場合管理者
				if (loginInfo.getLoginFlag() == 0) {
					forwardpath = "/productList";
				} else if (loginInfo.getLoginFlag() == 1) {
					forwardpath = "/view/menu.jsp";
					return;
				}
			}
			request.getRequestDispatcher(forwardpath).forward(request, response);
		}
	}
}
