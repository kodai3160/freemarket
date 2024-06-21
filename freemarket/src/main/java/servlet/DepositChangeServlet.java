package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/depositChange")
public class DepositChangeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		
		ProductionInfoDAO productDao = new ProductionInfoDAO();
		
		ProductionInfo product = new ProductionInfo();
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			//画面から送信される商品IDを受け取ります
			int productid = Integer.parseInt(request.getParameter("product_id"));
			
			//画面から送信される入金情報を受け取ります
			int flag = Integer.parseInt(request.getParameter("deposit_status"));
			
			//DAOクラスに定義したupdateDeposit()メソッドを利用して入金情報情報を変更します
			productDao.updateDeposit(productid,flag);
			
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} 
			
		
		
			//「DepositServlet」へフォワードします。
			request.getRequestDispatcher("/deposit").forward(request, response);
			
		}

	}
