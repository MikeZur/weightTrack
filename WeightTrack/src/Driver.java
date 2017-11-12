import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	
	static Pers user = new Pers();
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> a = Parser.getKey();
		//System.out.println(a.toString());
		
		String s = Main.getter();
		
		//System.out.println(s);
		
		int[] i = Parser.parse(s,a);
		System.out.println(Arrays.toString(i));
		
		ArrayList<Food> al = new ArrayList<Food>();
		al = Structure.makeList();
		for(int k = 0; k < i.length; k++){
			if(i[k] == 1){
			Food f = al.get(k);
			
			user.addCal(f.getcalories());
			user.addCarb(f.getcarbohydrates());
			user.addFat(f.getfats());
			user.addProt(f.getprotein());
			user.addSugar(f.getsugar());
			
			}
			
		}
		System.out.println(user.toString());
	}

}
