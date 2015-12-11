
public class DiferSQLInsetr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
private void insertDades(String user, String mail, String web, String summary,String comment){
		
		String query = "insert into test.comments (myuser, email, webpage,summary,datum,comments) values (?,?,?,?,?,?)";
		
		try{
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, user);
			statement.setString(2, mail);
			statement.setString(3, web);
			statement.setString(4, summary);
			statement.setDate(5, getCurrentDate());
			statement.setString(6, comment);
			int x = statement.executeUpdate();
			System.out.println(x);
		}catch (SQLException e){
			System.out.println("SQLException");
			e.printStackTrace();
		}
		System.out.println("Usuari Creat Amb Exit");
	}
  private static java.sql.Date getCurrentDate() {
	    Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}