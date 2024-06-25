package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.LoginInfo;
import bean.MemberInfo;
import bean.ProductionInfo;
import dao.MemberInfoDAO;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			//セッションから取得
			HttpSession session = request.getSession();
			LoginInfo loginObj = (LoginInfo) session.getAttribute("loginInfo");
			
			MemberInfoDAO memberInfoDAO = new MemberInfoDAO();
			
			MemberInfo memberInfo = memberInfoDAO.selectByUser(loginObj.getUserId());
			
			ProductionInfoDAO productDao = new ProductionInfoDAO(); 
			
			ArrayList<ProductionInfo> productList = productDao.selectByBuyerid(memberInfo.getMember_id());
			
			request.setAttribute("product_list", productList);
			
				
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、入金情報の表示は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/view/deposit.jsp").forward(request, response);
		
	}
}