package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//エラーメッセージ変数
		String error = null;
		String cmd = null;

		String check = null;
		try {

			//画面からの入力情報を受け取るためのエンコード設定
			request.setCharacterEncoding("UTF-8");

			check = request.getParameter("check");

			if (check.equals("init")) {
				return;
			}

			//パスワードとメールアドレスを登録するためのオブジェクト
			LoginInfoDAO infoDao = new LoginInfoDAO();
			//LoginInfoオブジェクト
			LoginInfo logInfo = new LoginInfo();
			//MemberInfoDAOクラスのオブジェクト
			MemberInfoDAO objDao = new MemberInfoDAO();
			//登録する会員情報を確認するMemberInfoオブジェクト作成
			MemberInfo info = new MemberInfo();

			//メールアドレス
			String inputEmail = request.getParameter("email");
			//パスワード
			String inputPassword = request.getParameter("password");
			//生年月日
			String calendar = request.getParameter("calendar");
			//電話番号
			String phone = request.getParameter("phone");
			//ニックネーム
			String nickname = request.getParameter("nickname");
			//姓
			String surname = request.getParameter("surname");
			//名
			String name = request.getParameter("name");
			//姓かな
			String kanaSurname = request.getParameter("kana_surname");
			//名かな
			String kanaName = request.getParameter("kana_name");
			//郵便番号
			String zipCode = request.getParameter("zipCode");
			//都道府県
			String prefectures = request.getParameter("prefectures");
			//都道府県かな
			String kana_prefectures = request.getParameter("kana_prefectures");
			//市区町村
			String municipality = request.getParameter("municipality");
			//市区町村かな
			String kana_municipality = request.getParameter("kana_municipality");
			//町名
			String town = request.getParameter("chou_name");
			//町名かな
			String kana_town = request.getParameter("kana_chou");
			//番地
			String street = request.getParameter("street_adress");
			//建物名
			String building = request.getParameter("building");
			//建物名かな
			String kana_building = request.getParameter("kana_building");

			//メールアドレスが未入力の場合の入力チェック
			if (inputEmail.equals("")) {
				error = "メールアドレスが未入力の為、会員登録は行えませんでした。";
				cmd = "membership";
				return;
			}
			//パスワードが未入力の場合
			if (inputPassword.equals("")) {
				error = "パスワードが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//名前が未入力の場合
			if (surname.equals("")) {
				error = "姓が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kanaSurname.equals("")) {
				error = "ふりがなが未入力な為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (name.equals("")) {
				error = "名前が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kanaName.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//郵便番号未入力
			if (zipCode.equals("")) {
				error = "郵便番号が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			//住所未入力
			if (prefectures.equals("")) {
				error = "都道府県が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kana_prefectures.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (municipality.equals("")) {
				error = "市町村が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kana_municipality.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (town.equals("")) {
				error = "町名が未入力の為、会員登録が行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kana_town.equals("")) {
				error = "ふりがなが未入力の為、会員登録が行えませんでしたえ。";
				cmd = "membership";
				return;
			}
			if (street.equals("")) {
				error = "番地が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}
			if (building.equals("")) {
				error = "番地が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}
			if (kana_building.equals("")) {
				error = "番地が未入力の為、会員登録を行えませんでした。";
				cmd = "membership";
				return;
			}

			//画面からのメアドとパスワードを受け取り、オブジェクトに格納
			infoDao.insert(inputEmail, inputPassword);
			logInfo = infoDao.selectByUser(inputEmail, inputPassword);

			//生年月日から年齢を計算
			LocalDate birthDate = LocalDate.of(Integer.parseInt(calendar.substring(0, 4)),
					Integer.parseInt(calendar.substring(5, 7)), Integer.parseInt(calendar.substring(8, 10)));
			//現在の日付を取得
			LocalDate currentDate = LocalDate.now();
			//年数を計算
			long years = ChronoUnit.YEARS.between(birthDate, currentDate);
			// 月日を考慮した年齢計算
			if (birthDate.plusYears(years).isAfter(currentDate)) {
				years = years - 1;
			}
			//年齢
			int age = (int) years;

			// 現在日時を取得
			LocalDateTime nowDate = LocalDateTime.now();

			// 表示形式を指定
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // ①
			String formatNowDate = dtf1.format(nowDate); // ②

			//会員情報を格納する
			info.setUser_id(logInfo.getUserId());
			info.setSurname(surname);
			info.setKana_surname(kanaSurname);
			info.setName(name);
			info.setKana_name(kanaName);
			info.setAge(Integer.valueOf(age).toString());
			info.setTel(phone);
			info.setPrefectures(prefectures);
			info.setKana_prefectures(kana_prefectures);
			info.setMunicipality(municipality);
			info.setKana_municipality(kana_municipality);
			info.setChou_name(town);
			info.setKana_chou_name(kana_town);
			info.setStreet_address(street);
			info.setBuilding_name(building);
			info.setKana_building_name(kana_building);
			info.setBirth_date(calendar);
			info.setWithdrawal(0);
			info.setUpdate_date(formatNowDate);
			info.setPhotograph("");
			info.setExhibition_area("");
			info.setNickname(nickname);
			info.setZipcode(Integer.parseInt(zipCode));

			//insertメソッドを利用してinfoオブジェクトに格納された会員データをDBへ登録
			objDao.insert(info);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員登録は行えませんでした。";
			cmd = "membership";

		} catch (NumberFormatException e) {
			error = "郵便番号の値が不正の為、会員登録は行えませんでした。";
			cmd = "membership";
		} finally {
			if (check.equals("init")) {
				request.getRequestDispatcher("/view/membership.jsp").forward(request, response);
			} else if (error != null) {
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
