package dao;

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
	public MemberInfo selectByUser(int userid) {
		//オブジェクト生成
		MemberInfo memberInfo = new MemberInfo();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM memberinfo WHERE "
				+ "user_id =" + userid;

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
				memberInfo.setPhotograph(rs.getString("photograph"));
				memberInfo.setExhibition_area(rs.getString("exhibition_area"));
				memberInfo.setNickname(rs.getString("nickname"));
				memberInfo.setZipcode(rs.getInt("zipcode"));
				memberInfo.setKana_building_name(rs.getString("kana_building_name"));
				memberInfo.setChou_name(rs.getString("chou_name"));
				memberInfo.setKana_chou_name(rs.getString("kana_chou_name"));
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
	 * ユーザーIDで絞った会員情報を取得するメソッド
	 * 
	 * @param userid
	 * @return ユーザーIDで絞った会員情報
	 * 
	 */
	public MemberInfo selectByMemberId(int memberid) {
		//オブジェクト生成
		MemberInfo memberInfo = new MemberInfo();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM memberinfo WHERE "
				+ "member_id =" + memberid;

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
				memberInfo.setPhotograph(rs.getString("photograph"));
				memberInfo.setExhibition_area(rs.getString("exhibition_area"));
				memberInfo.setNickname(rs.getString("nickname"));
				memberInfo.setZipcode(rs.getInt("zipcode"));
				memberInfo.setKana_building_name(rs.getString("kana_building_name"));
				memberInfo.setChou_name(rs.getString("chou_name"));
				memberInfo.setKana_chou_name(rs.getString("kana_chou_name"));
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
	public ArrayList<MemberInfo> selectByUserList(ArrayList<Integer> useridList) {
		//リスト
		ArrayList<MemberInfo> memberInfoList = new ArrayList<MemberInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		try {
			con = getConnection();
			smt = con.createStatement();

			for (int userid : useridList) {
				//SQL作成
				String sql = "SELECT * FROM memberinfo WHERE "
						+ "user_id =" + userid;

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
					memberInfo.setPhotograph(rs.getString("photograph"));
					memberInfo.setExhibition_area(rs.getString("exhibition_area"));
					memberInfo.setNickname(rs.getString("nickname"));
					memberInfo.setZipcode(rs.getInt("zipcode"));
					memberInfo.setKana_building_name(rs.getString("kana_building_name"));
					memberInfo.setChou_name(rs.getString("chou_name"));
					memberInfo.setKana_chou_name(rs.getString("kana_chou_name"));
					
					memberInfoList.add(memberInfo);
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
				memberInfo.setPhotograph(rs.getString("photograph"));
				memberInfo.setExhibition_area(rs.getString("exhibition_area"));
				memberInfo.setNickname(rs.getString("nickname"));
				memberInfo.setZipcode(rs.getInt("zipcode"));
				memberInfo.setKana_building_name(rs.getString("kana_building_name"));
				memberInfo.setChou_name(rs.getString("chou_name"));
				memberInfo.setKana_chou_name(rs.getString("kana_chou_name"));
				
				memberInfoList.add(memberInfo);
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
	 * DBに会員情報を登録するメソッド
	 *
	 * @param 会員情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(MemberInfo memberInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "INSERT INTO memberinfo VALUES(" + 
			"NULL" + "," + 
			memberInfo.getUser_id() + ",'" +
			memberInfo.getSurname() + "','" +
			memberInfo.getKana_surname() + "','" +
			memberInfo.getName() + "','" +
			memberInfo.getKana_name() + "','" +
			memberInfo.getAge() + "','" +
			memberInfo.getTel() + "','" +
			memberInfo.getPrefectures() + "','" +
			memberInfo.getKana_prefectures() + "','" +
			memberInfo.getMunicipality() + "','" +
			memberInfo.getKana_municipality() + "','" +
			memberInfo.getStreet_address() + "','" +
			memberInfo.getBuilding_name() + "','" +
			memberInfo.getBirth_date() + "'," +
			0 + ",'" +
			memberInfo.getUpdate_date() + "','" +
			memberInfo.getPhotograph() + "','" +
			memberInfo.getExhibition_area() + "','" +
			memberInfo.getNickname() + "','" +
			memberInfo.getZipcode() + "','" +
			memberInfo.getKana_building_name() + "','" +
			memberInfo.getChou_name() + "','" +
			memberInfo.getKana_chou_name() + "')";
			
			
			
			//DBに接続
			con = getConnection();
			//SQL送信準備
			smt = con.createStatement();
			//SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソース開放
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
	}

	/**
	 * DBに会員情報を削除するメソッド
	 *
	 * @param ユーザーID
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void delete(int userid) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "DELETE FROM memberinfo WHERE user_id = " + userid;
			//DBに接続
			con = getConnection();
			//SQL送信準備
			smt = con.createStatement();
			//SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソース開放
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
	}

	/**
	 * DBに会員情報を変更するメソッド
	 *
	 * @param 会員情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void update(MemberInfo memberInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE memberinfo " + 
			"SET member_id=" + memberInfo.getMember_id() + 
			",user_id=" + memberInfo.getUser_id() +
			",surname='" + memberInfo.getSurname() +
			"',kana_surname='" + memberInfo.getKana_surname() +
			"',age='" + memberInfo.getAge() +
			"',tel='" + memberInfo.getTel() +
			"',prefectures='" + memberInfo.getPrefectures() +
			"',kana_prefectures='" + memberInfo.getKana_prefectures() +
			"',municipality='" + memberInfo.getMunicipality() +
			"',kana_municipality='" + memberInfo.getKana_municipality() +
			"',street_address='" + memberInfo.getStreet_address() +
			"',building_name='" + memberInfo.getBuilding_name() +
			"',birth_date='" + memberInfo.getBirth_date() +
			"',withdrawal=" + memberInfo.getWithdrawal() +
			"',update_date=" + "NOW()" +
			"',photograph='" + memberInfo.getPhotograph() +
			"',exhibition_area='" + memberInfo.getExhibition_area() +
			"',nickname='" + memberInfo.getNickname() +
			"',zipcode='" + memberInfo.getZipcode() +
			"',kana_building_name='" + memberInfo.getKana_building_name() +
			"',chou_name='" + memberInfo.getChou_name() +
			"',kana_chou_name='" + memberInfo.getKana_chou_name() +
			" WHERE user_id='" + memberInfo.getUser_id() + "'";
			//DBに接続
			con = getConnection();
			//SQL送信準備
			smt = con.createStatement();
			//SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソース開放
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
	}
}
