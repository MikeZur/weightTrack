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
				System.out.println(a.get(k));
			}
		}
	}

}
