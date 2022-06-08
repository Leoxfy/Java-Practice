package work2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class LoginConnection {
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		new LoginConnection();
	}
	public LoginConnection() {
		initDriver();
		connectSql();
	}
	void initDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	void connectSql() {
		String url = "jdbc:mysql://localhost:3306/test?"
				+ "&useSSL=false"
				+ "&serverTimezone=UTC";
		String user = "root";
		String password = "123";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	boolean check(String uu, String pp) {
		String executeString = "select user,password from admin "
				+ "where user='" + uu + "'";
		try {
			rs = statement.executeQuery(executeString);
			if(rs.next()) {
				String a = rs.getString(1);
				String b = rs.getString(2);
				if(uu.equals(a) && pp.equals(b)) {
					return true;
				}
			}else {
				System.out.println("出错");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	void ending() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
