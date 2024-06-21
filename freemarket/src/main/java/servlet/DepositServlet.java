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

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			ProductionInfoDAO productDao = new ProductionInfoDAO(); 
			
			ArrayList<ProductionInfo> productList = productDao.selectAll();
			
			request.setAttribute("product_list", productList);
			
				
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/view/deposit.jsp").forward(request, response);
		
	}
}