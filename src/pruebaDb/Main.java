package pruebaDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static final String URL = "jdbc:sqlite:dbprueba";

	public static void main(String[] args) {
		try {
			run();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void run() throws SQLException {
		Connection con = DriverManager.getConnection(URL);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from prueba");
		while (rs.next()) {
			System.out.printf("%d | %d | %d\n", rs.getInt(1), rs.getInt(2), rs.getInt(3));
		}
		rs.close();
		st.close();
		con.close();
	}

}
