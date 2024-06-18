package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class ProductDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーメッセージ
		String error = null;
		//DAOのオブジェクトを生成
		ProductionInfoDAO productInfoDao = new ProductionInfoDAO();
		//画面からの情報を受け取る
		request.getParameter("!!!!!仮の値!!!!!");
		//オブジェクトに格納
		ProductionInfo productinfo = 
		
	}
}
