package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bean.ProductionInfo;

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

	/**
	 * （会員ID）ユーザーIDを元に全ての商品情報が取得できる。
	 * ユーザー自身の商品の一覧とかに使用できる
	 * 
	 * @param 会員ID
	 * @return 	会員IDを元にした商品情報のリスト
	 */
	public ArrayList<ProductionInfo> selectByMemberid(int memberid) {

		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE member_id=" + memberid;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}

	/**
	 * 全商品情報のリストを取得するメソッド
	 * 
	 * @return 全商品情報のリスト
	 */
	public ArrayList<ProductionInfo> selectAll() {
		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}

	/**
	 * （購入者ID）ユーザーIDを元に全ての商品情報が取得できる。
	 * ユーザー自身の商品の一覧とかに使用できる
	 * 
	 * @param 購入者ID
	 * @return 	購入者IDを元にした商品情報のリスト
	*/
	public ArrayList<ProductionInfo> selectByBuyerid(int buyerid) {
		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE buyer_id=" + buyerid;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}

	/**
	 * 入金フラグが1かどうかを元に全ての商品情報が取得できる。
	 * 管理者の売上げの確認とかで使用する
	 *  
	 * @return 	入金されている商品情報のリスト
	*/
	public ArrayList<ProductionInfo> selectByDepositStatus() {
		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE transaction_flag= '1'";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}
	
	/**
	 * 入金フラグが1かどうかを元に全ての商品情報が取得できる。
	 * 管理者の売上げの確認とかで使用する
	 *  
	 * @return 	入金されている商品情報のリスト
	*/
	public ArrayList<ProductionInfo> selectByTransactionDown() {
		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE transaction_flag= '0'";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}

	/**
	 * 引数で与えられたユーザーIDを元に入金フラグが1かどうかを元に全ての商品情報が取得できる。
	 * 入金情報を受け取る場面に使える
	 * 
	 * @return 	入金されている商品情報のリスト
	*/
	public ArrayList<ProductionInfo> selectByDepositAndMemberid(int memberid) {
		//リスト
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE transaction_flag= '1' AND member_id = " + memberid;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成
				ProductionInfo productionInfo = new ProductionInfo();

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);
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
		return productionInfoList;
	}
	
	/**
	 * （会員ID）商品情報IDをもとに商品情報を取得する
	 * 
	 * @param 商品ID
	 * @return 	商品IDを元にした商品情報
	 */
	
	public ProductionInfo selectByProductid(int productid) {
		//リスト
		ProductionInfo productionInfo = new ProductionInfo();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT * FROM productioninfo WHERE product_id = " + productid;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//オブジェクト生成

				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

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
		return productionInfo;
	}

	/**
	 * 商品を登録している全ての会員IDの取得ができる
	 * 出品者一覧でMemberInfoDAOとともに使うことが出来る。
	 *  
	 * @return 	商品を登録している全ての会員ID
	*/
	public ArrayList<Integer> selectMemberidList() {
		//リスト
		ArrayList<Integer> memberidList = new ArrayList<Integer>();

		//DB接続
		Connection con = null;
		Statement smt = null;

		//SQL作成
		String sql = "SELECT DISTINCT member_id FROM productioninfo";

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				//メンバーIDを格納
				memberidList.add(rs.getInt("member_id"));
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
		return memberidList;
	}

	/**
	 * DBに商品情報を登録するメソッド
	 *
	 * @param 商品情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(ProductionInfo productionInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "INSERT INTO productioninfo VALUES(" +
					"NULL" + "," +
					productionInfo.getMember_id() + "," +
					"NULL" + ",'" +
					productionInfo.getCategory() + "','" +
					productionInfo.getItem_description() + "','" +
					productionInfo.getItem_condition() + "','" +
					productionInfo.getUses_number() + "','" +
					productionInfo.getColor() + "','" +
					productionInfo.getPicture() + "','" +
					productionInfo.getProduct() + "','" +
					productionInfo.getCost_price() + "','" +
					productionInfo.getSelling_price() + "','" +
					productionInfo.getSize() + "','" +
					productionInfo.getShipping_addres() + "','" +
					productionInfo.getUpdate_time() + "','" +
					productionInfo.getUntil_shipping() + "','" +
					productionInfo.getOrigin_region() + "','" +
					productionInfo.getShipping_method() + "','" +
					productionInfo.getRegistration_date() + "','" +
					productionInfo.getUpdate_date() + "','" +
					productionInfo.getDetails_update_date() + "','" +
					"0" + "','" +
					"0" + "','" +
					"" + "','" +
					"0" + "','" +
					"" + "','" +
					"1" + "')";
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
	 * DBに商品情報を変更するメソッド
	 *
	 * @param 商品情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void update(ProductionInfo productionInfo) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
	        // 表示形式を指定
	        DateTimeFormatter dtf1 =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // ①
	        String formatNowDate = dtf1.format(LocalDateTime.now()); // ②
			
	        String transaction = productionInfo.getTransaction_flag();
	        
	        int transaction_flag = Integer.parseInt(transaction);			
			//SQL文
			String sql = "UPDATE productioninfo " + 
			"SET product_id= " + productionInfo.getProduct_id() + 
			",member_id= " + productionInfo.getMember_id() +
			",buyer_id= " + productionInfo.getBuyer_id() +
			",category= '" + productionInfo.getCategory() +
			"',item_description= '" + productionInfo.getItem_description() +
			"',item_condition= '" + productionInfo.getItem_condition() +
			"',uses_number= '" + productionInfo.getUses_number() +
			"',color= '" + productionInfo.getColor() +
			"',picture= '" + productionInfo.getPicture() +
			"',product= '" + productionInfo.getProduct() +
			"',cost_price= '" + productionInfo.getCost_price() +
			"',selling_price= '" + productionInfo.getSelling_price() +
			"',size= '" + productionInfo.getSize() +
			"',shipping_addres= '" + productionInfo.getShipping_addres() +
			"',update_time= '" + formatNowDate +
			"',until_shipping= '" + productionInfo.getUntil_shipping() +
			"',origin_region= '" + productionInfo.getOrigin_region() +
			"',shipping_method= '" + productionInfo.getShipping_method() +
			"',registration_date= '" + productionInfo.getRegistration_date() +
			"',update_date= '" + formatNowDate +
			"',details_update_date= '" + formatNowDate +
			"',shipping_status_flag= '" + productionInfo.getShipping_status_flag() +
			"',transaction_flag= " + transaction_flag +
			",transaction_completion_date= '" + formatNowDate +
			"',deposit_status= " + 0 +
			",deposit_update_date= '" + formatNowDate +
			"',display_flag= " + productionInfo.getDisplay_flag() +
			" WHERE product_id=" + productionInfo.getProduct_id();
			
			
			//DBに接続
			con = getConnection();
			//SQL送信準備
			smt = con.createStatement();
			//SQL実行
			int count = smt.executeUpdate(sql);
			
			System.out.println(count);

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
	 * 発送状況を変更できる
	 *
	 * @param 0未発送　1発送済み
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void updateShipping(int productid, int flag) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE productioninfo " + 
			"SET shipping_status_flag='" + flag +
			"',update_time=" + "NOW()" +
			" WHERE product_id=" + productid;
			
			
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
	 * 取引情報を変更できる
	 *
	 * @param 0未取引　1取引中 2取引済
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void updateTransaction(int productid, int flag) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE productioninfo " + 
			"SET transaction_flag='" + flag +
			"',update_time=" + "NOW()" +
			",transaction_completion_date=" + "NOW()" +
			" WHERE product_id=" + productid;
			
			
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
	 * 入金状況を変更できる
	 *
	 * @param 0未入金　1入金済み
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void updateDeposit(int productid, int flag) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE productioninfo " + 
			"SET deposit_status='" + flag +
			"',update_time=" + "NOW()" +
			",deposit_update_date=" + "NOW()" +
			" WHERE product_id=" + productid;
			
			
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
	 * 公開状況を変更できる
	 *
	 * @param 0非公開　1公開
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void updateDisplayFlag(int productid, int flag) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "UPDATE productioninfo " + 
			"SET display_flag='" + flag +
			"',update_time=" + "NOW()" +
			" WHERE product_id=" + productid;
			
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
	 * DBに商品情報を削除するメソッド
	 *
	 * @param ユーザーID
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void delete(int productid) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql = "DELETE FROM productioninfo WHERE product_id = '" + productid + "'";
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
	 * DBから指定された商品データを検索するメソッド
	 *
	 * @param キーワード
	 * @return 条件から絞れた商品情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public ArrayList<ProductionInfo> search(String keyword) {

		//オブジェクト生成
		Connection con = null;
		Statement smt = null;

		//商品情報を管理しておくArrayListを生成
		ArrayList<ProductionInfo> productionInfoList = new ArrayList<>();

		try {
			//SQL文
			String sql = "SELECT isbn,title,price FROM productioninfo " +
					"WHERE category LIKE '%" + keyword + 
					"%' OR item_description LIKE '%" + keyword + 
					"%' OR item_condition LIKE '%" + keyword +
					"%' OR uses_number LIKE '%" + keyword + 
					"%' OR color LIKE '%" + keyword + 
					"%' OR product LIKE '%" + keyword + 
					"%' OR selling_price LIKE '%" + keyword + 
					"%' OR size LIKE '%" + keyword + 
					"%' OR origin_region LIKE '%" + keyword + 
					"%' OR shipping_method LIKE '%" + keyword +"%'";
			//DBに接続
			con = getConnection();
			//SQL送信準備
			smt = con.createStatement();
			//SQL実行
			ResultSet rs = smt.executeQuery(sql);

			//ポインタが移動できなくなるまで繰り返す。データを全件確認
			while (rs.next()) {
				//情報を格納するオブジェクトを生成
				ProductionInfo productionInfo = new ProductionInfo();
				
				//情報を格納
				productionInfo.setProduct_id(rs.getInt("product_id"));
				productionInfo.setMember_id(rs.getInt("member_id"));
				productionInfo.setBuyer_id(rs.getInt("buyer_id"));
				productionInfo.setCategory(rs.getString("category"));
				productionInfo.setItem_description(rs.getString("item_description"));
				productionInfo.setItem_condition(rs.getString("item_condition"));
				productionInfo.setUses_number(rs.getString("uses_number"));
				productionInfo.setColor(rs.getString("color"));
				productionInfo.setPicture(rs.getString("picture"));
				productionInfo.setProduct(rs.getString("product"));
				productionInfo.setCost_price(rs.getString("cost_price"));
				productionInfo.setSelling_price(rs.getString("selling_price"));
				productionInfo.setSize(rs.getString("size"));
				productionInfo.setShipping_addres(rs.getString("shipping_addres"));
				productionInfo.setUpdate_time(rs.getString("update_time"));
				productionInfo.setUntil_shipping(rs.getString("until_shipping"));
				productionInfo.setOrigin_region(rs.getString("origin_region"));
				productionInfo.setShipping_method(rs.getString("shipping_method"));
				productionInfo.setRegistration_date(rs.getString("registration_date"));
				productionInfo.setUpdate_date(rs.getString("update_date"));
				productionInfo.setDetails_update_date(rs.getString("details_update_date"));
				productionInfo.setShipping_status_flag(rs.getString("shipping_status_flag"));
				productionInfo.setTransaction_flag(rs.getString("transaction_flag"));
				productionInfo.setTransaction_completion_date(rs.getString("transaction_completion_date"));
				productionInfo.setDeposit_status(rs.getString("deposit_status"));
				productionInfo.setDeposit_update_date(rs.getString("deposit_update_date"));
				productionInfo.setDisplay_flag(rs.getString("display_flag"));

				productionInfoList.add(productionInfo);

			}

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
		return productionInfoList;
	}
}
