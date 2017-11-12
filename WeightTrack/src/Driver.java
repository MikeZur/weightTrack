import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> a = Parser.getKey();
		//System.out.println(a.toString());
		
		String s = Main.getter();
		
		//System.out.println(s);
		
		int[] i = Parser.parse(s,a);
		System.out.println(Arrays.toString(i));
		
		for(int k = 0; k < i.length; k++){
			if(i[k] == 1){
				if(k == 0){
					Pers.addCal(Banana.getcalories());
					Pers.addSugar(Banana.getsugar());
					Pers.addProt(Banana.getprotein());
					Pers.addCarb(Banana.getcarbohydrates());
					Pers.addFat(Banana.getfats());
				}
				if(k==3){
					Pers.addCal(Soylent.getcalories());
					Pers.addSugar(Soylent.getsugar());
					Pers.addProt(Soylent.getprotein());
					Pers.addCarb(Soylent.getcarbohydrates());
					Pers.addFat(Soylent.getfats());
				}
			}
		}
		
	}

}
