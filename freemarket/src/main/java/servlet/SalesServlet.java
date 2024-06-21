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

@WebServlet("/sales")
public class SalesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String error = "";
		
		try {
		
		//ProductionInfoDAOをインスタンス化する
		ProductionInfoDAO productDao = new ProductionInfoDAO();
		
		// 関連メソッドを呼び出し、戻り値としてProductionInfoオブジェクトのリストを取得する
		ArrayList<ProductionInfo> productList = productDao.selectByDepositStatus();

		request.setAttribute("product_List", productList);
			
		}catch(IllegalStateException e) {
			error="DB接続エラーの為、一覧表示は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/view/sales.jsp").forward(request, response);
	}
}