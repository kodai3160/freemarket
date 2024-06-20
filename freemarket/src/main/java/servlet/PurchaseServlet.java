package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//エラーメッセージ
		String error = null;


		try {
			//エンコーディング
			req.setCharacterEncoding("UTF-8");

			
		} catch (IllegalStateException e) {
			error = "DB接続エラーが発生しました。";
		} finally {
			//遷移先用変数
			String forwardPath = "";
			if (error == null) {
				forwardPath = "/view/purchase.jsp";
			} else {
				forwardPath = "/view/error.jsp";
				req.setAttribute("error", error);
			}
			//画面遷移
			req.getRequestDispatcher(forwardPath).forward(req, resp);
		}
	}
}
