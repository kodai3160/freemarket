package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.AdministratorInfo;

public class AdministratorInfoDAO {
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
	 * 管理者情報のリストを取得するメソッド
	 * 
	 * @return 管理者情報のリスト
	 */
	public ArrayList<AdministratorInfo> selectAll() {
		//リスト
		ArrayList<AdministratorInfo> administratorInfoList = new ArrayList<AdministratorInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM administratorinfo";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				AdministratorInfo administratorInfo = new AdministratorInfo();

				//情報を格納
				administratorInfo.setAdministratorId(rs.getInt("administrator_id"));
				administratorInfo.setUserId(rs.getInt("user_id"));
				administratorInfo.setSurname(rs.getString("surname"));
				administratorInfo.setKanaSurname(rs.getString("kana_surname"));
				administratorInfo.setName(rs.getString("name"));
				administratorInfo.setKanaName(rs.getString("kana_name"));
				administratorInfo.setRegistrationDate(rs.getString("registration_date"));
				administratorInfo.setUpdateDate(rs.getString("update_date"));			
				
				administratorInfoList.add(administratorInfo);
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
		return administratorInfoList;
	}
	
	/**
	 * DBに管理者情報を登録するメソッド
	 *
	 * @param 管理者情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(AdministratorInfo administratorInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "INSERT INTO administratorinfo VALUES(" +
					"NULL" + "," +
					administratorInfo.getUserId() + "," +
					administratorInfo.getSurname() + "','" +
					administratorInfo.getKanaSurname() + "','" +
					administratorInfo.getName() + "','" +
					administratorInfo.getKanaName() + "'," +
					"NOW()" + "," +
					"NOW()" + ")";
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
	 * DBに管理者情報を変更するメソッド
	 *
	 * @param 管理者情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void update(AdministratorInfo administratorInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE administratorinfo " + 
			"SET administrator_id=" + administratorInfo.getAdministratorId() + 
			",user_id=" + administratorInfo.getUserId() +
			",surname='" + administratorInfo.getSurname() +
			"',kana_surname='" + administratorInfo.getKanaSurname() +
			"',name='" + administratorInfo.getName() +
			"',kana_name='" + administratorInfo.getKanaName() +
			"',registration_date=" + "NOW()" +
			",update_date=" + "NOW()" +
			" WHERE administrator_id=" + administratorInfo.getAdministratorId();
			
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
	 * DBに管理者情報を削除するメソッド
	 *
	 * @param 管理者ID
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void delete(int administratorid) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "DELETE FROM administratorinfo WHERE product_id = '" + administratorid + "'";
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
