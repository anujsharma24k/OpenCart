package LogicPractice;

import java.util.Scanner;

public class LogicDemo {

	public static void main(String[] args) {
		

		/*
		int a = 10, b = 20;
		
		String result = (a>b)? "a is Greater": "b is greater";
		System.out.println(result);
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the week day name : ");
		String dayName = sc.nextLine().toLowerCase();
		
		switch(dayName)
		{
		case "monday" : System.out.println(dayName + " is day 1 of the week"); break;
		case "tuesday" : System.out.println(dayName + " is day 2 of the week"); break;
		case "wednesday" : System.out.println(dayName + " is day 2 of the week"); break;
		case "thursday" : System.out.println(dayName + " is day 4 of the week"); break;
		case "friday" : System.out.println(dayName + " is day 5 of the week"); break;
		case "saturday" : System.out.println(dayName + " is day 6 of the week"); break;
		case "sunday" : System.out.println(dayName + " is day 7 of the week"); break;
		default : System.out.println(dayName + " is invalid input");
		};
		
	}

}
