
public class Main {

	public static void main(String[] args) throws Exception {
			MySQLAccess dao = new MySQLAccess();
			
			MethodInsert i = new MethodInsert();
			
			//dao.readDataBase();
			//dao.insertFila("jordi","jordill14@gmail.com","gourmon.com","gourmet","good food");
			//(int codeing, String nameing, String codemm, double kcal, double carbs, double protein, double fat, double salt, int qty)			
			i.insertIngredients(10, "olives", "g", 80.5, 67.2, 12.1 , 6.9, 8.1 , 100);
	}
}
