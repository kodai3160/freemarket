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

@WebServlet("/onSalerProducts")
public class OnSalerProductsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String error = "";
		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");
			
			//パラメータ取得
			int memberid = Integer.parseInt(request.getParameter("member_id"));
			
			//ProductionInfoDAOをインスタンス化
			ProductionInfoDAO productsDaoObj = new ProductionInfoDAO();
			
			//会員IDから全ての商品情報を取得するメソッドを呼び出し、ArrayListへ格納
			ArrayList<ProductionInfo> productsList = productsDaoObj.selectByMemberid(memberid);
			
			//リクエストスコープに登録
			request.setAttribute("products_list", productsList);
			
		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品一覧表示は行えませんでした。";
		} finally {
			//エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				//エラーが無い場合はproductList.jspにフォワード
				request.getRequestDispatcher("/view/onSalerProducts.jsp").forward(request, response);
			} else {
				//エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
