package servlet;

import java.io.IOException;

import bean.LoginInfo;
import bean.MemberInfo;
import bean.ProductionInfo;
import dao.LoginInfoDAO;
import dao.MemberInfoDAO;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.SendMail;

@WebServlet("/shippingChange")
public class ShippingChangeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
			productDao.updateShipping(productid, flag);
			
			product = productDao.selectByProductid(productid);

			if (product.getBuyer_id() == 0) {
				error = "購入者がいません。";
				return;
			}
			
			MemberInfoDAO memberInfoDAO = new MemberInfoDAO();
			
			MemberInfo memberInfo = memberInfoDAO.selectByMemberId(product.getBuyer_id());
			
			LoginInfoDAO loginInfoDAO = new LoginInfoDAO();
			
			LoginInfo loginInfo = loginInfoDAO.selectByUserId(memberInfo.getUser_id());
			
			SendMail.sendShippingMail(loginInfo.getEmail(), product.getProduct(), memberInfo.getNickname());

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ステータス変更は行えませんでした。 ";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {

				//「DepositServlet」へフォワードします。
				request.getRequestDispatcher("/onSaleDetail").forward(request, response);
			}
		}
	}

}
