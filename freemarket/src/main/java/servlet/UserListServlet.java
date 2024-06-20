package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.MemberInfo;
import dao.MemberInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = null;
		String cmd = null;
		
		
		try {
			//memberInfoDAOをインスタンス化
			MemberInfoDAO objDao = new MemberInfoDAO();
			
			//関連メソッドを呼び出し戻り値としてMemberInfoオブジェクトのリストを取得する
			ArrayList<MemberInfo> memberList = objDao.selectAll();
			
			//リクエストスコープへ登録
			request.setAttribute("memberList", memberList);
			
		}catch(IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "menu";
		}finally{
			//エラーの有無でフォワード先を呼び分ける
			if(error == null) {
				//エラーがないとき
				request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
				
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
			
		}
	}
}