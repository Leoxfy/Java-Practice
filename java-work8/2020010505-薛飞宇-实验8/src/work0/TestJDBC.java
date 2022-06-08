package work0;

import java.sql.*;

public class TestJDBC {

	public static void main(String[] args){
		//0. 将jar包拷贝至项目中
		//项目文件add path
		
		//1.加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("加载驱动成功。");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败。");
		}
		
		//2.建立连接
		String url = "jdbc:mysql://localhost:3306/test?"
				+ "&useSSL=false"
				+ "&serverTimezone=UTC";
		String username = "root";
		String password = "123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
		}
		//3.执行sql语句
		Statement sql = null;
		try {
			sql = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SQLStatement = "select * from students";
		ResultSet rs = null;
		try {
			rs = sql.executeQuery(SQLStatement);
			while(rs.next()) {
				String id = rs.getString("stuid");
				String name = rs.getString("stuname");
				System.out.println("id:"+id+"name:"+name);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//4.释放资源
		try {
			sql.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
