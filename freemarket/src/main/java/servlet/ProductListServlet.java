package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");
			
			//ProductsDAOをインスタンス化する
			ProductionInfoDAO productsDaoObj = new ProductionInfoDAO();

			//関連メソッドを呼び出し、戻り値としてBookオブジェクトのリストを取得する
			ArrayList<ProductionInfo> productsList = productsDaoObj.selectByTransactionDown();

			//リクエストスコープに"products_list"という名前で格納する
			request.setAttribute("products_list", productsList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品一覧表示は行えませんでした。";
			cmd = "login";
		} finally {
			//エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				//エラーが無い場合はproductList.jspにフォワード
				request.getRequestDispatcher("/view/productList.jsp").forward(request, response);
			} else {
				//エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
