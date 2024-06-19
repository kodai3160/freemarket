package servlet;

import java.io.IOException;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/productDetail")
public class ProductDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーメッセージ
		String error = null;
		//DAOのオブジェクトを生成
		ProductionInfoDAO productInfoDao = new ProductionInfoDAO();
		//画面からの情報を受け取る
		int productID = Integer.parseInt(request.getParameter("product_id"));
		//エンコーディング
		request.setCharacterEncoding("UTF-8");
		//オブジェクトに格納
		try {
			 ProductionInfo productInfo = productInfoDao.selectByProductid(productID);
			 if(productInfo.getProduct_id()==0){
				 error = "該当する商品がありませんでした。";
				 return;
			 }
			 
		//セッションに格納する
		HttpSession  session= request.getSession();
		session.setAttribute("productInfo",productInfo);
		
		} catch (IllegalStateException e) {
			error = "DB接続エラーが発生しました。";
		} finally {
			//遷移先用変数
			String forwardPath = "";
			if (error == null) {
				forwardPath = "/view/productDetail.jsp";
			} else {
				forwardPath = "/view/error.jsp";
				request.setAttribute("error", error);
			}
			//画面遷移
			request.getRequestDispatcher(forwardPath).forward(request, response);
		}
	}
}
