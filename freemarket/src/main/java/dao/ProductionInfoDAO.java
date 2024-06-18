package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductionInfoDAO {
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
	
	//商品に登録されている全てのユーザーIDの取得
	
}	
