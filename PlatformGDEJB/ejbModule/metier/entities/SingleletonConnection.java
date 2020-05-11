package metier.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.Entity;

public class SingleletonConnection {
	private static Connection connection;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3308/db_base","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void setConnection(Connection connection) {
		SingleletonConnection.connection = connection;
	}

}