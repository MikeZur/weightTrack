public class Pers {
	
	int cal = 0;
	int sugar = 0;
	int prot = 0;
	int carb = 0;
	int fat = 0;
	int goal;
	
	public Pers(){
		
	}
	
	public void setGoal(int a){
		goal = a;
	}
	
	public int getCal(){
		return cal;
	}
	
	public int getSugar(){
		return sugar;
	}
	
	public int getProt(){
		return prot;
	}
	
	public int getCarb(){
		return carb;
	}
	
	public int getFat(){
		return fat;
	}
	
	public int getGoal(){
		return goal;
	}
	
	public void addCal(int a){
		cal += a;
	}
	
	public void addSugar(int a){
		sugar += a;
	}
	
	public void addProt(int a){
		prot += a;
	}
	
	public void addCarb(int a){
		carb += a;
	}
	public void addFat(int a){
		fat += a;
	}
	public String toString(){
		String s = ("You've eaten: " + cal + " calories, " + sugar + " grams of sugar, " + prot + " grams of protein, " + carb + "grams of carbs, and " + fat +" grams of fat!");
		return s;
	}
}
