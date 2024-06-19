package servlet;

import java.io.IOException;

import bean.LoginInfo;
import bean.MemberInfo;
import dao.MemberInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userInformation")
public class UserInformationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーメッセージ用変数
		String error = null;
		//DAOオブジェクトを生成
		MemberInfoDAO memberDao = new MemberInfoDAO();
		try {
			//セッションの値を受け取る
			HttpSession session = request.getSession();
			LoginInfo loginObj = (LoginInfo) session.getAttribute("loginInfo");
			if (loginObj == null) {
				error = "セッション切れのため、ログイン画面に戻ります。";
				return;
			}
			//エンコーディング
			request.setCharacterEncoding("UTF-8");
			//セッションに登録された値から、会員情報を取得する
			MemberInfo memberInfoObj = memberDao.selectByUser(Integer.toString(loginObj.getUserId()));
			if(memberInfoObj.getMember_id()==0) {
				error = "ユーザー情報見つかりませんでした。";
				return;
			}
			//リクエストスコープに登録する
			request.setAttribute("memberInfo", memberInfoObj);

		} catch (IllegalStateException e) {
			error = "DB接続エラーが発生しました。";
		} finally {
			//遷移先用変数
			String forwardPath = "";
			if (error == null) {
				forwardPath = "/view/userInformation.jsp";
			} else {
				forwardPath = "/view/error.jsp";
				request.setAttribute("error", error);
			}
			//画面遷移
			request.getRequestDispatcher(forwardPath).forward(request, response);
		}
	}
}