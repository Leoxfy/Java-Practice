package work1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task1 {
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new Task1();
	}
	public Task1() {
		initDriver();
		connectSql();
		executeSql();
		ending();
	}
	void initDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("加载驱动成功。");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败。");
		}
	}
	void connectSql() {
		String url = "jdbc:mysql://localhost:3306/test?"
				+ "useSSL=false"
				+ "&serverTimezone=UTC";
		String user = "root";
		String password = "123";
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功。");
		} catch (SQLException e) {
			System.out.println("连接失败。");
		}
	}
	void executeSql() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		addRecord();
		queryRecord();
		updataSalary();
		queryMax();
	}
	void addRecord() {
		String executeString1 = "insert into employee "
				+ "(id, name, sex, salary) "
				+ "values "
				+ "(1002, 'Tom', 'male', 2600)";
		String executeString2 = "insert into employee "
				+ "(id, name, sex, salary) "
				+ "values "
				+ "(1003, 'Mary', 'female', 3200)";
		String executeString3 = "insert into employee "
				+ "(id, name, sex, salary) "
				+ "values "
				+ "(1004, 'Peter', 'male', 3000)";
		String executeString4 = "insert into employee "
				+ "(id, name, sex, salary) "
				+ "values "
				+ "(1005, 'John', 'male', 7000)";
		String executeString5 = "insert into employee "
				+ "(id, name, sex, salary) "
				+ "values "
				+ "(1006, 'Paul', 'male', 4000)";
		try {
			statement.executeUpdate(executeString1);
			statement.executeUpdate(executeString2);
			statement.executeUpdate(executeString3);
			statement.executeUpdate(executeString4);
			statement.executeUpdate(executeString5);
			System.out.println("添加记录成功。");
		} catch (SQLException e) {
			System.out.println("添加失败。");
		}
	}
	void queryRecord() {
		String executeString = "select * from employee "
				+ "where name='Peter'";
		try {
			rs = statement.executeQuery(executeString);
			if(rs.next()) {
				System.out.println("查询Peter信息如下：");
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				int salary = rs.getInt(4);
				System.out.println("id:"+id
						+"\tname:"+name
						+"\tsex:"+sex
						+"\tsalary:"+salary);
			}
		} catch (SQLException e) {
			System.out.println("查询失败。");
		}
	}
	void updataSalary() {
		String executeString1 = "select * from employee";
		try {
			rs = statement.executeQuery(executeString1);
			System.out.println("查询表的信息如下：");
			System.out.println("id\tname\tsex\tsalary");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				int salary = rs.getInt(4);
				System.out.println(id+"\t"+name+"\t"+sex+"\t"+salary);
			}
		} catch (SQLException e1) {
			System.out.println("查询失败。");
		}
		
		String executeString2 = "update employee set salary = salary + 1500";
		try {
			statement.executeUpdate(executeString2);
			System.out.println("更新成功。");
		} catch (SQLException e) {
			System.out.println("更新失败。");
		}
	}
	void queryMax() {
		String executeString = "select * from employee order by salary desc limit 1";
		try {
			rs = statement.executeQuery(executeString);
			if(rs.next()) {
				System.out.println("查询工资最高者为：");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				System.out.println("name:"+name+"\tsalary:"+salary);
			}
		} catch (SQLException e) {
			System.out.println("查询失败。");
			e.printStackTrace();
		}
	}
	void ending() {
		try {
			rs.close();
			connection.close();
			System.out.println("断开连接。");
		} catch (SQLException e) {
			System.out.println("断开连接失败。");
		}
	}
}
