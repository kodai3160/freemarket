package servlet;

import java.io.IOException;

import bean.LoginInfo;
import bean.MemberInfo;
import dao.LoginInfoDAO;
import dao.MemberInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/membership")
public class MembershipSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラーメッセージ変数
		String error = null;
		String cmd = null;

		try {
			
			
			
            //パスワードとメールアドレスを登録するためのオブジェクト
			LoginInfoDAO infoDao = new LoginInfoDAO();
			//LoginInfoオブジェクト
			LoginInfo logInfo = new LoginInfo();
			//MemberInfoDAOクラスのオブジェクト
			MemberInfoDAO objDao = new MemberInfoDAO();
			//登録する会員情報を確認するMemberInfoオブジェクト作成
			MemberInfo info = new MemberInfo();

			//画面からの入力情報を受け取るためのエンコード設定
			request.setCharacterEncoding("UTF-8");

			//メールアドレスが未入力の場合の入力チェック
			String inputEmail = request.getParameter("email");
			if (inputEmail.equals("")) {
				error = "メールアドレスが未入力の為、会員登録は行えませんでした。";
				cmd = "membership";
				return;
			}
			//パスワードが未入力の場合
			String inputPassword = request.getParameter("password");
			if (inputPassword.equals("")) {
				error = "パスワードが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//名前が未入力の場合
			String inputSurName = request.getParameter("surname");
			if (inputSurName.equals("")) {
				error = "姓が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputKanaS = request.getParameter("kana_surname");
			if (inputKanaS.equals("")) {
				error = "ふりがなが未入力な為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputName = request.getParameter("name");
			if (inputName.equals("")) {
				error = "名前が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputKanaName = request.getParameter("kana_name");
			if (inputKanaName.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//郵便番号未入力
			String inputCode = request.getParameter("zipCode");
			if (inputCode.equals("")) {
				error = "郵便番号が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//住所未入力
			String inputPrefecture = request.getParameter("prefectures");
			if (inputPrefecture.equals("")) {
				error = "都道府県が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputKanaP = request.getParameter("kana_prefectures");
			if (inputKanaP.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputMunicipality = request.getParameter("municipality");
			if (inputMunicipality.equals("")) {
				error = "市町村が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputKanaM = request.getParameter("kana_municipality");
			if (inputKanaM.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputChou = request.getParameter("chou_name");
			if (inputChou.equals("")) {
				error = "町名が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			String inputKanaC = request.getParameter("kana_chou");
			if (inputKanaC.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでしたえ。";
				cmd = "membership";
				return;
			}
			String inputStreetAdress = request.getParameter("street_adress");
			if (inputStreetAdress.equals("")) {
				error = "番地が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}

			//画面からのメアドとパスワードを受け取り、オブジェクトに格納
			infoDao.insert(inputEmail, inputPassword);
			logInfo = infoDao.selectByUser(inputEmail, inputPassword);
			info.setUser_id(logInfo.getUserId());
			
			//生年月日取得
			String inputBirthdate = request.getParameter("calender");
			//電話番号取得
			String inputPhoneNum = request.getParameter("phone");
			
			//画面からの入力情報を受け取り、infoオブジェクトに格納
			info.setSurname(inputSurName);
			info.setKana_surname(inputKanaS);
			info.setName(inputName);
			info.setKana_name(inputKanaName);
			info.setZipcode(Integer.parseInt(inputCode));
			info.setPrefectures(inputPrefecture);
			info.setKana_prefectures(inputKanaP);
			info.setMunicipality(inputMunicipality);
			info.setKana_municipality(inputKanaM);
			info.setChou_name(inputChou);
			info.setKana_chou_name(inputKanaC);
			info.setStreet_address(inputStreetAdress);
			info.setBirth_date(inputBirthdate);
			info.setTel(inputPhoneNum);
			//insertメソッドを利用してinfoオブジェクトに格納された会員データをDBへ登録
			objDao.insert(info);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員登録は行えませんでした。";
			cmd = "membership";

		} catch (NumberFormatException e) {
			error = "郵便番号の値が不正の為、会員登録は行えませんでした。";
			cmd = "membership";
		} finally {
			if (error != null) {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			} else {
				//login画面へフォワード
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			}
		}

	}

}
