import java.util.Scanner;

class Goal{
	public static void go(){

		double goal = 0;
		double finalcal = 0;
		String activitylevel;
		//int dailycal = 0;
 
		Scanner sc = new Scanner(System.in);

		System.out.println("How much do you weigh?");
		//int weight = sc.nextInt();
		String xx = sc.nextLine();
		int weight = Integer.parseInt(xx);

		System.out.println("Are you a male?");

		//boolean gender = sc.nextBoolean();
		xx = sc.nextLine();
		boolean gender = Boolean.parseBoolean(xx);

		double bmr;
		
		if (gender){
			bmr = 11 * weight;
			//System.out.println("Your BMR is: ");
			}
		else{
			bmr = 10 * weight;
			//System.out.println("Your BMR is: ");
			}
		
		System.out.println("Enter your activity level (i.e. Light, Medium, or Heavy: ");
		activitylevel = sc.nextLine();
		System.out.println("xx " + activitylevel);
		//double goal = 0;
		if (activitylevel.equals("light")){
			goal = bmr * 1.2;
			}
		else if (activitylevel.equals("medium")){
			goal = bmr * 1.55;
			}
		else if(activitylevel.equals("heavy")){
			goal = bmr * 1.9;
			}
		else{
			System.out.println("Invalid Fitness Level.");
			}  
		
		System.out.println("How many calories have you consumed today?");
		xx = sc.nextLine();
		int dailycal = Integer.parseInt(xx);

		double calremaining = goal - dailycal;
		//System.out.println("Enter your activity level (i.e. Light, Medium, or Heavy: ");
		//activitylevel = sc.nextLine();

		System.out.println("Your calorie goal is: " + goal + "\nYour calories consumed for the day so far is: " + dailycal +  "\nYour activity level is: " + activitylevel+ "\nYour calories remaining for the day is: " + calremaining);
 




	}
}
