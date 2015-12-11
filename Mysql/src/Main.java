
public class Main {

	public static void main(String[] args) throws Exception {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
			dao.insertFila("jordi","jordill14@gmail.com","gourmon.com","gourmet","good food");
	}
}
