package servlet;

import java.io.IOException;

import bean.MemberInfo;
import dao.MemberInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * フリマシステムにおけるユーザー詳細情報機能に関する処理をおこなうサーブレットクラス
 *
 */

//@WebServletアノテーションで呼び出すURLパターンを定義
@WebServlet("/userDetail")
public class UserDetailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラー変数の宣言
		String error = "";
		//コマンド変数の宣言
		String cmd = "";

		try {
			//MemberInfoDAOクラスのオブジェクトを生成
			MemberInfoDAO memberDao = new MemberInfoDAO();

			//画面から送信される情報を受け取るためのエンコードを設定	
			request.setCharacterEncoding("UTF-8");

			//getParameterメソッドで画面から送信される情報を受け取る
			String user_id = request.getParameter("user_id");
			cmd = request.getParameter("cmd");

			//MemberInfoDAOクラスに定義したselectByUser（）メソッドを利用してユーザー情報を取得
			MemberInfo memberData = memberDao.selectByUser(Integer.parseInt(user_id));

			//取得したユーザー情報を「memberInfo」という名前でリクエストスコープに登録	 
			request.setAttribute("memberInfo", memberData);

			//DBに接続できない場合
		} catch (Exception e) {
			error = "DB接続エラーの為、ユーザー詳細は表示できませんでした。";
			cmd = "logout";

		} finally {
			// エラーの有無でフォワード先を分岐する
			if (error.equals("")) {
				//cmd情報の値を判定し、「detail」の場合は「userDetail.jsp」へフォワード処理を行う
				if (cmd.equals("userDetail")) {
					request.getRequestDispatcher("/view/userDetail.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/view/update.jsp").forward(request, response);
				}
			} else {
				//エラーありの場合「error.jsp」へフォワード処理を行う
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
