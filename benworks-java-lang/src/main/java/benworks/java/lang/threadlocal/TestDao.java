package benworks.java.lang.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDao {
	private Connection conn;// ①一个非线程安全的变量

	public void addTopic() throws SQLException {
		Statement stat = conn.createStatement();// ②引用非线程安全变量
		// …
	}
}
