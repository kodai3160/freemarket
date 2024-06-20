package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginInfo;

/**
 * 
 */
/**
 * 
 */
public class LoginInfoDAO {

	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/fleamarketdb";
	private static String USER = "root";
	private static String PASSWD = "root123";

	private static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public LoginInfo selectByUser(String email, String password) {
		LoginInfo login = new LoginInfo();

		Connection con = null;
		Statement smt = null;

		String sql = "SELECT * FROM logininfo WHERE "
				+ "email ='" + email + "' AND password='" + password + "'";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				login.setUserId(rs.getInt("user_id"));
				login.setEmail(rs.getString("email"));
				login.setPassword(rs.getString("password"));
				login.setLoginFlag(rs.getInt("login_flag"));
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
		return login;
	}
	
	/**
	 * DBにログイン情報を登録するメソッド
	 *
	 * @param ログイン情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(String email, String password) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "INSERT INTO logininfo VALUES(" +
					"NULL" + ",'" +
					email + "','" +
					password + "'," +
					0 + ")";
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
	 * DBからユーザーIDをもとに情報を取得する
	 * 
	 * @param ユーザーID
	 * @return ログイン情報
	 */
	public LoginInfo selectByUserId(int user_id) {
		//オブジェクト生成
		LoginInfo loginInfo = new LoginInfo();
		
		Connection con = null;
		Statement smt = null;

		
		String sql = "SELECT * FROM logininfo WHERE "
				+ "user_id =" + user_id;
		
		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				loginInfo.setUserId(rs.getInt("user_id"));
				loginInfo.setEmail(rs.getString("email"));
				loginInfo.setPassword(rs.getString("password"));
				loginInfo.setLoginFlag(rs.getInt("login_flag"));
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
		
		return loginInfo;
	}
}