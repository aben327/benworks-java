package benworks.java.lang.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		@Override
		protected Connection initialValue() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sango3", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	};

	public static Connection getConnection() {
		return connectionHolder.get();
	}

	public static void setConnection(Connection conn) {
		connectionHolder.set(conn);
	}

	public static void main(String[] args) {
		ConnectionManager manager = new ConnectionManager();
		Connection onnection1 = manager.getConnection();
		Connection onnection2 = manager.getConnection();
	}
}
