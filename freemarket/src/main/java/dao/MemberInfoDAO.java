package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.MemberInfo;

public class MemberInfoDAO {
	//DB接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/fleamarketdb";
	private static String USER = "root";
	private static String PASS = "root123";

	/**
	 * DBに接続するインスタンスメソッド
	 *
	 * @return Connection
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	private static Connection getConnection() {
		try {
			//JDBCドライバの読込
			Class.forName(RDB_DRIVE);
			//DBに接続
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	/**
	 * ユーザーIDで絞った会員情報を取得するメソッド
	 * 
	 * @param userid
	 * @return ユーザーIDで絞った会員情報
	 * 
	 */
	public MemberInfo selectByUser(String userid) {
		//オブジェクト生成
		MemberInfo memberInfo = new MemberInfo();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM memberinfo WHERE "
				+ "user_id ='" + userid;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//情報を格納
				memberInfo.setMember_id(rs.getInt("member_id"));
				memberInfo.setUser_id(rs.getInt("user_id"));
				memberInfo.setSurname(rs.getString("surname"));
				memberInfo.setKana_surname(rs.getString("kana_surname"));
				memberInfo.setName(rs.getString("name"));
				memberInfo.setKana_name(rs.getString("kana_name"));
				memberInfo.setAge(rs.getString("age"));
				memberInfo.setTel(rs.getString("tel"));
				memberInfo.setPrefectures(rs.getString("prefectures"));
				memberInfo.setKana_prefectures(rs.getString("kana_prefectures"));
				memberInfo.setMunicipality(rs.getString("municipality"));
				memberInfo.setKana_municipality(rs.getString("kana_municipality"));
				memberInfo.setStreet_address(rs.getString("street_address"));
				memberInfo.setBuilding_name(rs.getString("building_name"));
				memberInfo.setBirth_date(rs.getString("birth_date"));
				memberInfo.setWithdrawal(rs.getInt("withdrawal"));
				memberInfo.setUpdate_date(rs.getString("update_date"));
				memberInfo.setPhotograph(rs.getBlob("photograph").getBytes(1, (int) rs.getBlob("photograph").length()));
				memberInfo.setExhibition_area(rs.getString("exhibition_area"));
				memberInfo.setNickname(rs.getString("nickname"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return memberInfo;
	}

	/**
	 * 商品登録をしている全てのユーザーIDを引数として設定することで
	 * 出品している全てのユーザーの会員情報を取得するメソッド
	 * 
	 * @param useridList（商品情報を登録している全てのユーザーID）
	 * @return 出品している全てのユーザーの会員情報
	 */
	public ArrayList<MemberInfo> selectByUserList(ArrayList<String> useridList) {
		//リスト
		ArrayList<MemberInfo> memberInfoList = new ArrayList<MemberInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		try {
			con = getConnection();
			smt = con.createStatement();

			for (String userid : useridList) {
				//SQL作成
				String sql = "SELECT * FROM memberinfo WHERE "
						+ "user_id ='" + userid;

				ResultSet rs = smt.executeQuery(sql);

				while (rs.next()) {
					//オブジェクト生成
					MemberInfo memberInfo = new MemberInfo();

					//情報を格納
					memberInfo.setMember_id(rs.getInt("member_id"));
					memberInfo.setUser_id(rs.getInt("user_id"));
					memberInfo.setSurname(rs.getString("surname"));
					memberInfo.setKana_surname(rs.getString("kana_surname"));
					memberInfo.setName(rs.getString("name"));
					memberInfo.setKana_name(rs.getString("kana_name"));
					memberInfo.setAge(rs.getString("age"));
					memberInfo.setTel(rs.getString("tel"));
					memberInfo.setPrefectures(rs.getString("prefectures"));
					memberInfo.setKana_prefectures(rs.getString("kana_prefectures"));
					memberInfo.setMunicipality(rs.getString("municipality"));
					memberInfo.setKana_municipality(rs.getString("kana_municipality"));
					memberInfo.setStreet_address(rs.getString("street_address"));
					memberInfo.setBuilding_name(rs.getString("building_name"));
					memberInfo.setBirth_date(rs.getString("birth_date"));
					memberInfo.setWithdrawal(rs.getInt("withdrawal"));
					memberInfo.setUpdate_date(rs.getString("update_date"));
					memberInfo.setExhibition_area(rs.getString("exhibition_area"));
					memberInfo.setNickname(rs.getString("nickname"));

					//写真の保存
					Blob photograph = rs.getBlob("photograph");
					memberInfo.setPhotograph(photograph.getBytes(1, (int) photograph.length()));
				}

			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return memberInfoList;
	}

	/**
	 * 全会員情報のリストを取得するメソッド
	 * 
	 * @param useridList（商品情報を登録している全てのユーザーID）
	 * @return 出品している全てのユーザーの会員
	 */
	public ArrayList<MemberInfo> selectAll() {
		//リスト
		ArrayList<MemberInfo> memberInfoList = new ArrayList<MemberInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL作成
			String sql = "SELECT * FROM memberinfo ORDER BY member_id";

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				MemberInfo memberInfo = new MemberInfo();

				//情報を格納
				memberInfo.setMember_id(rs.getInt("member_id"));
				memberInfo.setUser_id(rs.getInt("user_id"));
				memberInfo.setSurname(rs.getString("surname"));
				memberInfo.setKana_surname(rs.getString("kana_surname"));
				memberInfo.setName(rs.getString("name"));
				memberInfo.setKana_name(rs.getString("kana_name"));
				memberInfo.setAge(rs.getString("age"));
				memberInfo.setTel(rs.getString("tel"));
				memberInfo.setPrefectures(rs.getString("prefectures"));
				memberInfo.setKana_prefectures(rs.getString("kana_prefectures"));
				memberInfo.setMunicipality(rs.getString("municipality"));
				memberInfo.setKana_municipality(rs.getString("kana_municipality"));
				memberInfo.setStreet_address(rs.getString("street_address"));
				memberInfo.setBuilding_name(rs.getString("building_name"));
				memberInfo.setBirth_date(rs.getString("birth_date"));
				memberInfo.setWithdrawal(rs.getInt("withdrawal"));
				memberInfo.setUpdate_date(rs.getString("update_date"));
				memberInfo.setExhibition_area(rs.getString("exhibition_area"));
				memberInfo.setNickname(rs.getString("nickname"));

				//写真の保存
				Blob photograph = rs.getBlob("photograph");
				memberInfo.setPhotograph(photograph.getBytes(1, (int) photograph.length()));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return memberInfoList;
	}
}
