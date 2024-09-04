
import java.sql.*;

public class StudentDAO {
	
	    public void addStudent(int id,String name, int age, String dept) throws Exception {
	        String query = "INSERT INTO students (id, name, age, dept) VALUES (?,?, ?, ?)";
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, id);
	        stmt.setString(2, name);
	        stmt.setInt(3, age);
	        stmt.setString(4, dept);
	        stmt.executeUpdate();

	    }

	    public void updateStudent(int id, String name, int age, String dept) throws Exception {
	        String query = "UPDATE students SET name = ?, age = ?, dept = ? WHERE id = ?";
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement st = conn.prepareStatement(query);
	        st.setString(1, name);
	        st.setInt(2, age);
	        st.setString(3, dept);
	        st.setInt(4, id);
	        st.executeUpdate();
	    }

	    public void deleteStudent(int id) throws Exception {
	        String query = "DELETE FROM students WHERE id = ?";
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement st = conn.prepareStatement(query); 
	        st.setInt(1, id);
	        st.executeUpdate();
	        }  

	    public ResultSet getStudent(int id) throws Exception {
	        String query = "SELECT * FROM students WHERE id = ?";
	        ResultSet rs = null;
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement st = conn.prepareStatement(query);
	        st.setInt(1, id);
	        rs = st.executeQuery();
	        return rs;
	    }

	    public ResultSet getAllStudents() throws Exception {
	        String query = "SELECT * FROM students";
	        ResultSet rs = null;
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement st = conn.prepareStatement(query);
	        rs = st.executeQuery();
	        return rs;
	    }
	}


