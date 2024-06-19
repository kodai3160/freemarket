package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.MailInfo;

public class MailInfoDAO {
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
	 * 送信者IDをもとにしたメッセージ情報のリストを取得するメソッド
	 * 
	 * @return 送信者IDをもとにしたメッセージ情報のリスト
	 */
	public ArrayList<MailInfo> selectBySenderId(int senderid) {
		//リスト
		ArrayList<MailInfo> mailInfoList = new ArrayList<MailInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM mailinfo WHERE sender_id = " + senderid;

	 	try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				MailInfo mailInfo = new MailInfo();

				//情報を格納
				mailInfo.setMail_id(rs.getInt("mail_id"));
				mailInfo.setSender_id(rs.getInt("sender_id"));
				mailInfo.setReceiver_id(rs.getInt("receiver_id"));
				mailInfo.setMessage(rs.getString("message"));
				mailInfo.setSent_date(rs.getString("sent_date"));
				mailInfoList.add(mailInfo);
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
		return mailInfoList;
	}
	
	/**
	 * 受信者IDをもとにしたメッセージ情報のリストを取得するメソッド
	 * 
	 * @return 受信者IDをもとにしたメッセージ情報のリスト
	 */
	public ArrayList<MailInfo> selectByReceiverId(int receiverid) {
		//リスト
		ArrayList<MailInfo> mailInfoList = new ArrayList<MailInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM mailinfo WHERE receiver_id = " + receiverid;

	 	try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				MailInfo mailInfo = new MailInfo();

				//情報を格納
				mailInfo.setMail_id(rs.getInt("mail_id"));
				mailInfo.setSender_id(rs.getInt("sender_id"));
				mailInfo.setReceiver_id(rs.getInt("receiver_id"));
				mailInfo.setMessage(rs.getString("message"));
				mailInfo.setSent_date(rs.getString("sent_date"));
				mailInfoList.add(mailInfo);
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
		return mailInfoList;
	}
	
	/**
	 * DBにメール情報を登録するメソッド
	 *
	 * @param メール情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(MailInfo mailInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "INSERT INTO administratorinfo VALUES(" +
					"NULL" + "," +
					mailInfo.getSender_id() + "," +
					mailInfo.getReceiver_id() + "','" +
					mailInfo.getMessage() + "','" +
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
}
