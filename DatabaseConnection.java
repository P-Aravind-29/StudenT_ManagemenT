import java.sql.*;
public class DatabaseConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/student_db"; //use your db_name
    private static final String USER = "root";
    private static final String PASSWORD = "Mysql,29"; // Use your MySQL password

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
