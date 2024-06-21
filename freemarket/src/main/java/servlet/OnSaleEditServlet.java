package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/onSaleEdit")
public class OnSaleEditServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			//ProductionInfoDAOをインスタンス化
			ProductionInfoDAO productsDaoObj = new ProductionInfoDAO();

			//パラメータの取得
			String product = request.getParameter("product");
			String selling_price = request.getParameter("selling_price");
			String origin_region = request.getParameter("origin_region");
			String item_description = request.getParameter("item_description");
			String picture = request.getParameter("picture");

			//空白チェック
			if (product.equals("")) {
				error = "商品名が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (selling_price.equals("")) {
				error = "価格が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (origin_region.equals("")) {
				error = "出品地域が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (item_description.equals("")) {
				error = "商品説明が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (picture == null) {
				error = "画像が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}

			//ProductionInfoオブジェクト生成、セッターメソッドで設定
			ProductionInfo productionInfo = new ProductionInfo();
			productionInfo.setProduct(product);
			productionInfo.setSelling_price(selling_price);
			productionInfo.setOrigin_region(origin_region);
			productionInfo.setItem_description(item_description);
			productionInfo.setPicture(picture);

			//商品情報を変更するメソッド呼び出し、ArrayListへ格納
			productsDaoObj.update(productionInfo);

			//リクエストスコープに登録
			request.setAttribute("productionInfo", productionInfo);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品一覧表示は行えませんでした。";
		} finally {
			//エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				//エラーが無い場合はproductList.jspにフォワード
				request.getRequestDispatcher("/view/onSaleEdit.jsp").forward(request, response);
			} else {
				//エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
