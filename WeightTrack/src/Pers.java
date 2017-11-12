public class Pers {
	
	int cal = 0;
	int sugar = 0;
	int prot = 0;
	int carb = 0;
	int fat = 0;
	int goal = 0;
	boolean gender;
	String activityLvl;
	
	public Pers(){
		Goal.go();
		goal = Goal.goal;
		activityLvl = Goal.activitylevel;
	}
	public Pers(String info){
		String[] arr = info.split("\\s");
		cal = Integer.parseInt(arr[0]);
		sugar = Integer.parseInt(arr[1]);
		prot = Integer.parseInt(arr[2]);
		carb = Integer.parseInt(arr[3]);
		fat = Integer.parseInt(arr[4]);
		goal = Integer.parseInt(arr[5]);
		gender = Boolean.parseBoolean(arr[6]);
		activityLvl = arr[7];
	}
	
	public int getCalRem(){
		return goal - cal;
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
		String s = (cal +" "+ sugar +" "+ prot +" "+ carb +" "+ fat +" "+ goal +" "+ gender +" "+ activityLvl);
		return s;
	}
}
