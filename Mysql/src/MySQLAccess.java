import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Connection;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
			// Statements allow to issue SQL queries to the database
		
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from feedback.comments");
			writeResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
			
	private void writeResultSet(ResultSet resultSet) throws
		SQLException {
			// ResultSet is initially before the first data set
			while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
			}
		}
	
	
	public void insertFila (String myuser, String email, String webpage, String summary, String comments) throws Exception {
		
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
			
			String sentencia = "INSERT INTO comments (myuser,email,webpage,datum,summary,comments) VALUES (?,?,?,NOW(),?,?)";
			PreparedStatement s = connect.prepareStatement(sentencia);
			s.setString(1, myuser);
			s.setString(2, email);
			s.setString(3, webpage);
			s.setString(4, summary);
			s.setString(5, comments);
			
			int res = s.executeUpdate();
			//System.out.println(res);
		
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		System.out.println("Ok,usuari insertat");
	}
	
	// You need to close the resultSet
		private void close() {
			try {
				if (resultSet != null) {
				resultSet.close();
				}
				if (statement != null) {
				statement.close();
				}
				if (connect != null) {
				connect.close();
				}
			} catch (Exception e) {
				
			}
		}
	
	
}