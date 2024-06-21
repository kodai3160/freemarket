package servlet;

import java.io.IOException;

import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDeleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";
		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");
			
			//パラメータ取得
			int productid = Integer.parseInt(request.getParameter("product_id"));

			//ProductionInfoDAOオブジェクトをインスタンス化
			ProductionInfoDAO productsDaoObj = new ProductionInfoDAO();

			//更新対象の有無のエラーチェック
			if (productsDaoObj.selectByProductid(productid) == null) {
				error = "削除対象の商品が存在しないため、商品削除処理は行えませんでした。";
				cmd = "list";
				return;
			}

			//商品の削除を行うメソッドを呼び出す
			productsDaoObj.delete(productid);
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍削除処理は行えませんでした。";
			cmd = "menu";
		} finally {
			//エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				//エラーが無い場合はListServletにフォワード
				request.getRequestDispatcher("/onSaleList").forward(request, response);
			} else {
				//エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}

}
