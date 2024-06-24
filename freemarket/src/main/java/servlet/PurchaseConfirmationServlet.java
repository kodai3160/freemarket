package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import jakarta.servlet.http.HttpSession;
import util.SendMail;

/**
 * フリマシステムにおける商品購入確認機能に関する処理をおこなうサーブレットクラス
 *
 */

//@WebServletアノテーションで呼び出すURLパターンを定義
@WebServlet("/purchaseConfirmation")
public class PurchaseConfirmationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//エラーメッセージ
		String error = null;

		try {
			//エンコーディング
			req.setCharacterEncoding("UTF-8");
			//セッションから取得
			HttpSession session = req.getSession();
			ProductionInfo productionInfo = (ProductionInfo) session.getAttribute("productInfo");
			
			//DBを更新する項目
			//DAOオブジェクトの生成
			ProductionInfoDAO productionDAO = new ProductionInfoDAO();
			
			//更新日時の更新
			//表示形式を指定し現在の日付を取得
	        DateTimeFormatter dtf1 =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatNowDate = dtf1.format(LocalDateTime.now());
			productionInfo.setUpdate_time(formatNowDate);
			//取引フラグの更新
			productionInfo.setTransaction_flag("1");
			
			//購入者IDの更新
			//ログイン情報の取得
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");	
			//ログイン情報から会員情報の取得
			MemberInfoDAO memberInfoDAO = new MemberInfoDAO();
			//ログイン情報の機能からちゃんと出来ていたら完成
			MemberInfo memberInfo = memberInfoDAO.selectByUser(loginInfo.getUserId());
			productionInfo.setBuyer_id(memberInfo.getMember_id());
						
			//DBを更新
			productionDAO.update(productionInfo);
			
			//購入状況のメール送信
			//必要な情報　メールアドレス　商品名　価格　購入されたユーザーの名前
			LoginInfoDAO loginInfoDAO = new LoginInfoDAO();
			//販売しているユーザーの会員情報
			MemberInfo member = memberInfoDAO.selectByMemberId(productionInfo.getMember_id());
			//販売しているユーザーのログイン情報
			LoginInfo memberLoginInfo = loginInfoDAO.selectByUserId(member.getUser_id());
			//出品者にメールの送信
			SendMail.sendBuyerMail(memberLoginInfo.getEmail(), productionInfo.getProduct(), productionInfo.getSelling_price(), member.getNickname());
			//購入者（ログインしているユーザー）にメールの送信
			SendMail.sendMemberMail(loginInfo.getEmail(), productionInfo.getProduct(), productionInfo.getSelling_price(), memberInfo.getNickname());
			

		} catch (IllegalStateException e) {
			error = "DB接続エラーが発生しました。";
		} finally {
			//遷移先用変数
			String forwardPath = "";
			if (error == null) {
				forwardPath = "/view/purchaseConfirmation.jsp";
			} else {
				forwardPath = "/view/error.jsp";
				req.setAttribute("error", error);
			}
			//画面遷移
			req.getRequestDispatcher(forwardPath).forward(req, resp);
		}

	}
	
}
