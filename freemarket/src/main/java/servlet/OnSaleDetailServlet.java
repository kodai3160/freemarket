package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/onSaleDetail")
public class OnSaleDetailServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		
	ProductionInfoDAO productDao = new ProductionInfoDAO();

	ProductionInfo product = new ProductionInfo();
	
	request.setCharacterEncoding("UTF-8");
	
	try {
		//int productid = Integer.parseInt(request.getParameter("product_id"));
		int num = 1;
	
		product = productDao.selectByProductid(num);
		
		request.setAttribute("productid", product);
		
	}catch(IllegalStateException e) {
		error="DB接続エラーの為、一覧表示は行えませんでした。 ";
		request.setAttribute("error", error);
		request.getRequestDispatcher("/view/error.jsp").forward(request, response);
	}
	
	request.getRequestDispatcher("/view/onSaleDetail.jsp").forward(request, response);

	}

}
