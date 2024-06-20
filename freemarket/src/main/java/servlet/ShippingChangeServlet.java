package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shippingChange")
public class ShippingChangeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		
		ProductionInfoDAO productDao = new ProductionInfoDAO();
		
		ProductionInfo product = new ProductionInfo();
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			//画面から送信される商品IDを受け取ります
			int productid = Integer.parseInt(request.getParameter("product_id"));
			
			//画面から送信される発送状況を受け取ります
			int flag = Integer.parseInt(request.getParameter("shipping_status_flag"));
			
			//DAOクラスに定義したupdateShipping()メソッドを利用して発送状況情報を変更します
			productDao.updateShipping(productid,flag);
			
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} 
			
		
		
			//「DepositServlet」へフォワードします。
			request.getRequestDispatcher("/onSaleDetail").forward(request, response);
			
		}

	}
