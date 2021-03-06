import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	
	
	public static void main(String[] args) throws IOException{
		
		Pers user;
		
		File m = new File("user.txt");
		
		if(m.exists()){
			FileReader r = new FileReader("user.txt");
			BufferedReader b = new BufferedReader(r);
			String dat = b.readLine();
			b.close();
			user = new Pers(dat);
		}
		else{
			user = new Pers();
		}
		
		
		
		
		
		ArrayList<String> a = Parser.getKey();
		//System.out.println(a.toString());
		
		String s = Main.get();
		
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
		System.out.println(user.getCalRem());
		
		PrintWriter writer = new PrintWriter("user.txt", "UTF-8");
		writer.println(user.toString());
		writer.close();
	}

}
