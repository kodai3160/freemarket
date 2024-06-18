package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginInfo;

public class loginInfoDAO {

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

String sql = "SELECT * FROM userinfo WHERE "
+ "email ='" + email + "' AND password='" + password + "'";

try {
con = getConnection();
smt = con.createStatement();

ResultSet rs = smt.executeQuery(sql);

if (rs.next()) {
login.setUserId(rs.getInt("user_id"));
login.setEmail(rs.getString("password"));
login.setPassword(rs.getString("email"));
login.setLoginFlag(rs.getInt("authority"));
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

}