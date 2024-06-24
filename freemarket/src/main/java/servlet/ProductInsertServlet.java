package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.LoginInfo;
import bean.MemberInfo;
import bean.ProductionInfo;
import dao.MemberInfoDAO;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * フリマシステムにおける商品登録機能に関する処理をおこなうサーブレットクラス
 *
 */

//@WebServletアノテーションで呼び出すURLパターンを定義
@WebServlet("/productInsert")
@MultipartConfig
public class ProductInsertServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラー変数の宣言
		String error = "";
		//コマンド変数の宣言
		String cmd = "";
		
		String check = "";

		try {

			//画面からの入力情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");
			
			check = request.getParameter("check");
			
			if(check.equals("init")) {
				return;
			}
			
			//商品名
			String name = request.getParameter("name");
			//価格
			String price = request.getParameter("price");
			//カテゴリ
			String category = request.getParameter("category");
			//状態
			String condition = request.getParameter("condition");
			//使用回数
			String num = request.getParameter("num");
			//色
			String color = request.getParameter("color");
			//サイズ
			String size = request.getParameter("size");
			//配送方法
			String delivery = request.getParameter("delivery");
			//発送までの予定日数
			String delivery_days = request.getParameter("delivery_days"); 
			//発送地域
			String region = request.getParameter("region");
			//商品説明
			String description = request.getParameter("description");
			//写真取得用の情報を受け取る
			Part filePart = request.getPart("image");
			String uploadDir = "";
			String filePath = "";
			String fileName = "";

			//写真取得処理
			if (filePart.getSize() != 0) {
				String contentDisposition = filePart.getHeader("content-disposition");
				Pattern pattern = Pattern.compile("filename=\"(.*)\"");
				Matcher matcher = pattern.matcher(contentDisposition);
				//抽出したファイル名が存在していれば抽出、なければ空白
				if (matcher.find()) {
					fileName = matcher.group(1);
				}else {
					fileName = "";
				}

				File file_name = new File(fileName);

				// ファイル保存先のディレクトリ
				uploadDir = getServletContext().getRealPath("/file").replace("\\", "/");
				//アップロード先のフォルダがなければ作成
				File uploadDirectory = new File(uploadDir);
				if (!uploadDirectory.exists()) {
					uploadDirectory.mkdirs();
				}

				// ファイルを指定されたディレクトリに保存
				// （具体的には以下の階層に保存される）
				// C:\ usr\kis_java_pkg_2023\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
				filePath = uploadDir + "/" + file_name.getName();
				try (InputStream inputStream = filePart.getInputStream()) {
					Files.copy(inputStream, new File(filePath).toPath(),StandardCopyOption.REPLACE_EXISTING);
				}
			}
			

			//値の入力チェックして各エラー処理をする
			//商品名が未入力の場合
			if (name.equals("")) {
				error = "商品名が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			//出品地域が未入力の場合
			if (region.equals("")) {
				error = "出品地域が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
				//価格が未入力の場合
			}
			if (price.equals("")) {
				error = "価格が未入力の為、商品登録処理は行えませんでした。 ";
				cmd = "list";
				return;
			}
			Pattern pattern = Pattern.compile("^[0-9]+$");
			if(price != null && !pattern.matcher(price).matches()) {
				error = "価格が文字列の為、商品登録処理は行えませんでした。 ";
				cmd = "list";
				return;
			}

			//ProductionInfoDAOクラスのオブジェクトを生成
			ProductionInfoDAO productionDao = new ProductionInfoDAO();

			//登録する商品情報を格納するProductionInfoオブジェクトを生成
			ProductionInfo productionInfo = new ProductionInfo();
			
			 // 現在日時を取得
	        LocalDateTime nowDate = LocalDateTime.now();

	        // 表示形式を指定
	        DateTimeFormatter dtf1 =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // ①
	        String formatNowDate = dtf1.format(nowDate); // ②
			
			//自動で設定される
			productionInfo.setProduct_id(0);
			//セッションから取得
			//セッションの値を受け取る
			HttpSession session = request.getSession();
			LoginInfo loginObj = (LoginInfo) session.getAttribute("loginInfo");
			MemberInfoDAO memberInfoDAO = new MemberInfoDAO();
			MemberInfo memberInfo = memberInfoDAO.selectByUser(loginObj.getUserId());
			//ログインしている会員ID
			productionInfo.setMember_id(memberInfo.getMember_id());
			//購入者ID　商品登録の為設定できない
			productionInfo.setBuyer_id(0);
			//カテゴリ
			productionInfo.setCategory(category);
			//商品説明
			productionInfo.setItem_description(description);
			//状態
			productionInfo.setItem_condition(condition);
			//使用回数
			productionInfo.setUses_number(num);
			//色
			productionInfo.setColor(color);			
			//商品名
			productionInfo.setProduct(name);
			//原価（必要？）
			productionInfo.setCost_price("");
			//価格
			productionInfo.setSelling_price(price);
			//サイズ
			productionInfo.setSize(size);
			//配送先　商品登録のため設定できない
			productionInfo.setShipping_addres("");
			//更新日
			productionInfo.setUpdate_time(formatNowDate);
			//発送までの日数
			productionInfo.setUntil_shipping(delivery_days);
			//発送地域
			productionInfo.setOrigin_region(region);
			//発送方法
			productionInfo.setShipping_method(delivery);
			//商品登録日
			productionInfo.setRegistration_date(formatNowDate);
			//商品更新日
			productionInfo.setUpdate_date(formatNowDate);
			//商品詳細更新日
			productionInfo.setDetails_update_date(formatNowDate);
			//発送状況フラグ DAO側で設定される
			productionInfo.setShipping_status_flag("");
			//取引フラグ DAO側で設定される
			productionInfo.setTransaction_flag("");
			//取引完了日　DAO側で設定される
			productionInfo.setTransaction_completion_date("");
			//入金状況フラグ DAO側で設定される
			productionInfo.setDeposit_status("");
			//入金情報更新日 DAO側で設定される
			productionInfo.setDeposit_update_date("");
			//表示フラグ　DAO側で設定される
			productionInfo.setDisplay_flag("");
			//写真
			productionInfo.setPicture("/freemarket/file/"+fileName);
			
			//DBに格納
			productionDao.insert(productionInfo);
			//DBに接続できない場合
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品登録処理は行えませんでした。";
			cmd = "logout";

		} finally {
			if (check.equals("init")) {
				request.getRequestDispatcher("/view/productInsert.jsp").forward(request, response);
			} else if (error.equals("")) {
				//エラーがない場合は「OnSaleListServlet」へフォワード処理を行う
				request.getRequestDispatcher("/productList").forward(request, response);
			} else {
				//エラーがある場合は「error.jsp」へフォワード処理を行う
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}